/**
 * Copyright (C)  版权所有
 * 文件名： GlobalFilter.java
 * 包名： com.loan.web.filter
 * 说明：
 * @author admin
 * @date Apr 11, 2016 3:37:26 PM
 * @version V1.0
 */ 
package com.loan.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 类名： GlobalFilter
 * 描述：
 * @author admin
 * @date Apr 11, 2016 3:37:26 PM
 *
 *
 */
public class GlobalFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest req = (HttpServletRequest)request;
	     String url = req.getRequestURI();
	     chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
