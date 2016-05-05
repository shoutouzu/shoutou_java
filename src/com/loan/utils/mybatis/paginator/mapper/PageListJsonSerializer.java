package com.loan.utils.mybatis.paginator.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.loan.utils.mybatis.paginator.PageList;

public class PageListJsonSerializer extends JsonSerializer<PageList>
{
  ObjectMapper mapper;

  public PageListJsonSerializer()
  {
    this.mapper = new ObjectMapper();
  }

  public PageListJsonSerializer(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public void serialize(PageList value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    Map map = new HashMap();
    map.put("totalCount", Integer.valueOf(value.getTotalCount()));
    map.put("totalPage", Integer.valueOf(value.getTotalPage()));
    map.put("currentPage", Integer.valueOf(value.getCurrentPage()));
    map.put("pageSize", Integer.valueOf(value.getPageSize()));
    map.put("content", new ArrayList(value));

    this.mapper.writeValue(jgen, map);
  }
}