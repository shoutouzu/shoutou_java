package com.loan.utils.mybatis.paginator;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;

import com.loan.utils.mybatis.paginator.dialect.Dialect;

@Intercepts({@org.apache.ibatis.plugin.Signature(type=org.apache.ibatis.executor.Executor.class, method="query", args={MappedStatement.class, Object.class, RowBounds.class, org.apache.ibatis.session.ResultHandler.class})})
public class PageInterceptor implements Interceptor{

	private static final Log logger = LogFactory.getLog(PageInterceptor.class);
	  private static Dialect DIALECT_CLASS = null;

	  private static int MAPPED_STATEMENT_INDEX = 0;
	  private static int PARAMETER_INDEX = 1;
	  private static int ROWBOUNDS_INDEX = 2;

	  public Object intercept(Invocation invocation)
	    throws Throwable
	  {
	    Object[] queryArgs = invocation.getArgs();

	    RowBounds rowBounds = (RowBounds)queryArgs[ROWBOUNDS_INDEX];
	    if (!(rowBounds instanceof Pageable)) {
	      return invocation.proceed();
	    }

	    MappedStatement mappedStatement = (MappedStatement)queryArgs[MAPPED_STATEMENT_INDEX];
	    Object parameterObject = queryArgs[PARAMETER_INDEX];
	    BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);

	    Map pageParameters = new HashMap();
	    if (parameterObject instanceof Map)
	      pageParameters.putAll((Map)parameterObject);
	    else {
	      for (ParameterMapping parameterMapping : boundSql.getParameterMappings()) {
	        pageParameters.put(parameterMapping.getProperty(), parameterObject);
	      }
	    }
	    List parameterMappings = new ArrayList(boundSql.getParameterMappings());

	    Pageable page = (Pageable)rowBounds;
	    if (page.isOnlySort()) {
	      StringBuilder sortSql = new StringBuilder(boundSql.getSql());
	      sortSql.append(" order by ").append(page.getSort());
	      queryArgs[MAPPED_STATEMENT_INDEX] = copyFromNewSql(mappedStatement, boundSql, sortSql.toString(), 
	        parameterMappings, pageParameters);
	      return invocation.proceed();
	    }

	    String sql = boundSql.getSql();
	    if (StringUtils.isNotBlank(page.getSort())) {
	      StringBuilder sortSql = new StringBuilder(sql);
	      sortSql.append(" order by ").append(page.getSort());
	      sql = sortSql.toString();
	    }

	    String pageSql = DIALECT_CLASS.buildPageSqlAndSetParameters(mappedStatement, sql, page, pageParameters, 
	      parameterMappings);

	    queryArgs[MAPPED_STATEMENT_INDEX] = copyFromNewSql(mappedStatement, boundSql, pageSql, parameterMappings, 
	      pageParameters);
	    queryArgs[PARAMETER_INDEX] = pageParameters;

	    queryArgs[ROWBOUNDS_INDEX] = new RowBounds(0, 2147483647);

	    int totalCount = getCount(mappedStatement, parameterObject, boundSql);
	    PageList pageList = new PageList(page.getCurrentPage(), page.getPageSize());
	    pageList.setTotalCount(totalCount);
	    int totalPage = totalCount / pageList.getPageSize() + ((totalCount % pageList.getPageSize() == 0) ? 0 : 1);
	    pageList.setTotalPage(totalPage);

	    Object result = invocation.proceed();
	    pageList.addAll((List)result);
	    return pageList;
	  }

	  public static int getCount(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql)
	    throws SQLException
	  {
	    String countSql = "select count(0) from (" + boundSql.getSql() + ") as total";

	    if (logger.isDebugEnabled()) {
	      logger.debug("Total count SQL [{}] " + countSql);
	      logger.debug("Total count Parameters: {} " + parameterObject);
	    }

	    Connection connection = null;
	    PreparedStatement countStmt = null;
	    ResultSet rs = null;
	    int count = 0;
	    try {
	      connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
	      countStmt = connection.prepareStatement(countSql);
	      DefaultParameterHandler handler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
	      handler.setParameters(countStmt);

	      rs = countStmt.executeQuery();
	      if (rs.next()) {
	        count = rs.getInt(1);
	      }
	      if (logger.isDebugEnabled()) {
	        logger.debug("Total count: {}" + count);
	      }
	    } finally {
	      try {
	        if (rs == null);
	        rs.close();
	      }
	      finally {
	        try {
	          if (countStmt == null) ;
	          countStmt.close();
	        }
	        finally {
	          if ((connection != null) && (!(connection.isClosed())))
	            connection.close();
	        }
	      }
	    }
	  return count;

	  }

	  private MappedStatement copyFromNewSql(MappedStatement ms, BoundSql boundSql, String sql, List<ParameterMapping> parameterMappings, Object parameter)
	  {
	    BoundSql newBoundSql = copyFromBoundSql(ms, boundSql, sql, parameterMappings, parameter);
	    return copyFromMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
	  }

	  private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String sql, List<ParameterMapping> parameterMappings, Object parameter)
	  {
	    BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, parameterMappings, parameter);
	    for (ParameterMapping mapping : boundSql.getParameterMappings()) {
	      String prop = mapping.getProperty();
	      if (boundSql.hasAdditionalParameter(prop)) {
	        newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
	      }
	    }
	    return newBoundSql;
	  }

	  private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource)
	  {
	    MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

	    builder.resource(ms.getResource());
	    builder.fetchSize(ms.getFetchSize());
	    builder.statementType(ms.getStatementType());
	    builder.keyGenerator(ms.getKeyGenerator());
	    if ((ms.getKeyProperties() != null) && (ms.getKeyProperties().length != 0)) {
	      StringBuffer keyProperties = new StringBuffer();
	      for (String keyProperty : ms.getKeyProperties()) {
	        keyProperties.append(keyProperty).append(",");
	      }
	      keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
	      builder.keyProperty(keyProperties.toString());
	    }

	    builder.timeout(ms.getTimeout());

	    builder.parameterMap(ms.getParameterMap());

	    builder.resultMaps(ms.getResultMaps());
	    builder.resultSetType(ms.getResultSetType());

	    builder.cache(ms.getCache());
	    builder.flushCacheRequired(ms.isFlushCacheRequired());
	    builder.useCache(ms.isUseCache());

	    return builder.build();
	  }

	  public Object plugin(Object target)
	  {
	    return Plugin.wrap(target, this);
	  }

	  public void setProperties(Properties properties)
	  {
	    logger.debug("mybatis setProperties");
	    if (DIALECT_CLASS == null)
	      synchronized (properties) {
	        if (DIALECT_CLASS == null) {
	          String dialectClassStr = properties.getProperty("dialectClass");

	          Class dialectClass = null;
	          try {
	            dialectClass = Class.forName(dialectClassStr);
	            Constructor constructor = dialectClass.getConstructor(new Class[0]);
	            DIALECT_CLASS = (Dialect)constructor.newInstance(new Object[0]);
	          } catch (Exception e) {
	            throw new RuntimeException(
	              new ClassNotFoundException("Cannot create dialect instance: " + 
	              dialectClass, e));
	          }
	          logger.debug("mybatis load dialectClass");
	        }
	      }
	  }

	  public static class BoundSqlSqlSource implements SqlSource
	  {
	    BoundSql boundSql;

	    public BoundSqlSqlSource(BoundSql boundSql)
	    {
	      this.boundSql = boundSql;
	    }

	    public BoundSql getBoundSql(Object parameterObject)
	    {
	      return this.boundSql;
	    }
	  }
	}