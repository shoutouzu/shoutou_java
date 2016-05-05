/**
 * Copyright (C)  版权所有
 * 文件名： ReturnEntity.java
 * 包名： com.loan.utils
 * 说明：
 * @author admin
 * @date Apr 26, 2016 4:17:36 PM
 * @version V1.0
 */ 
package com.loan.utils;
/**
 * 类名： ReturnEntity
 * 描述：
 * @author admin
 * @date Apr 26, 2016 4:17:36 PM
 *
 *
 */

import java.io.Serializable;

public class ReturnEntity
  implements Serializable
{
  private static final long serialVersionUID = -2335404331810149358L;
  private boolean isSuccess;
  private Object msg;
  private Integer code;

  public ReturnEntity()
  {
  }

  public ReturnEntity(boolean isSuccess, Object msg, Integer code)
  {
    this.isSuccess = isSuccess;
    this.msg = msg;
    this.code = code;
  }

  public boolean isSuccess() {
    return this.isSuccess;
  }

  public void setSuccess(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

  public Object getMsg() {
    return this.msg;
  }

  public void setMsg(Object msg) {
    this.msg = msg;
  }

  public Integer getCode() {
    return this.code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}