package com.loan.utils.mybatis.paginator.dialect;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;

import com.loan.utils.mybatis.paginator.Pageable;

public class OracleDialect
  implements Dialect
{
  public String buildPageSqlAndSetParameters(MappedStatement mappedStatement, String sql, Pageable page, Map<String, Object> pageParameters, List<ParameterMapping> parameterMappings)
  {
    StringBuilder pageSql = new StringBuilder(100);
    Integer beginrow = Integer.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
    Integer endrow = Integer.valueOf(page.getCurrentPage() * page.getPageSize());

    pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
    pageSql.append(sql);
    pageSql.append(" ) temp where rownum <= ?");
    pageSql.append(") where row_id > ?");

    pageParameters.put("__offset", beginrow);
    ParameterMapping parameterMapping = new ParameterMapping.Builder(mappedStatement.getConfiguration(), 
      "__offset", Integer.class).build();
    parameterMappings.add(parameterMapping);

    pageParameters.put("__limit", endrow);
    parameterMapping = new ParameterMapping.Builder(mappedStatement.getConfiguration(), "__limit", Integer.class)
      .build();
    parameterMappings.add(parameterMapping);

    return pageSql.toString();
  }
}