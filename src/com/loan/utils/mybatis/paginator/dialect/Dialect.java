package com.loan.utils.mybatis.paginator.dialect;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;

import com.loan.utils.mybatis.paginator.Pageable;

public abstract interface Dialect
{
  public static final String OFFSET_NAME = "__offset";
  public static final String LIMIT_NAME = "__limit";

  public abstract String buildPageSqlAndSetParameters(MappedStatement paramMappedStatement, String paramString, Pageable paramPageable, Map<String, Object> paramMap, List<ParameterMapping> paramList);
}