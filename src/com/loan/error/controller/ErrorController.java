/**
 * Copyright (C)  版权所有
 * 文件名： ErrorController.java
 * 包名： com.loan.error.controller
 * 说明：
 * @author admin
 * @date Apr 11, 2016 4:41:37 PM
 * @version V1.0
 */ 
package com.loan.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类名： ErrorController
 * 描述：
 * @author admin
 * @date Apr 11, 2016 4:41:37 PM
 *
 *
 */
@Controller
@RequestMapping("*")
public class ErrorController {
	@RequestMapping("*")
	public String error_405(){
		return "error/404";
	}
}
