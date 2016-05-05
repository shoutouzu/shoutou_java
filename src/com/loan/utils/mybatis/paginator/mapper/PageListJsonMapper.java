package com.loan.utils.mybatis.paginator.mapper;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.loan.utils.mybatis.paginator.PageList;

public class PageListJsonMapper extends ObjectMapper
{
  public PageListJsonMapper()
  {
    SimpleModule module = new SimpleModule("PageListJSONModule", 
      new Version(1, 0, 0, null, null, null));
    module.addSerializer(PageList.class, new PageListJsonSerializer(this));
    registerModule(module);
  }
}