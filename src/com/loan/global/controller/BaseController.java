/**
 * Copyright (C)  版权所有
 * 文件名： BaseController.java
 * 包名： com.loan.global.controller
 * 说明：
 * @author admin
 * @date Apr 26, 2016 4:18:54 PM
 * @version V1.0
 */ 
package com.loan.global.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.loan.utils.ReturnEntity;

/**
 * 类名： BaseController
 * 描述：
 * @author admin
 * @date Apr 26, 2016 4:18:54 PM
 *
 *
 */
public class BaseController
{
  protected ResponseEntity<?> responseJson(boolean isSuccess, Object msg, Integer code, HttpStatus status)
  {
    ReturnEntity returnEntity = new ReturnEntity(isSuccess, msg, code);

    return responseJson(returnEntity, status);
  }

  private ResponseEntity<?> responseJson(ReturnEntity obj, HttpStatus status)
  {
    String contentType = "text/plain;charset=UTF-8";
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Content-Type", contentType);
    return new ResponseEntity(obj, responseHeaders, status);
  }

  protected ResponseEntity<?> responseJsonForFail()
  {
    ReturnEntity returnEntity = new ReturnEntity(false, "参数有误", Integer.valueOf(0));
    return responseJson(returnEntity, HttpStatus.BAD_REQUEST);
  }
}