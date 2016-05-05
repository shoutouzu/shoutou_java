package com.loan.web.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.loan.article.dto.FriendDTO;
import com.loan.article.service.IArticleService;
import com.loan.global.service.IGlobalService;
import com.loan.utils.mybatis.paginator.Pageable;


public class WebConfigContextListener 
implements ServletContextListener, HttpSessionAttributeListener{
	private static Logger logger = Logger.getLogger(WebConfigContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("listenter初始化");
		ServletContext context = arg0.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		IArticleService articleService = (IArticleService)ctx.getBean("articleServiceImpl");
		IGlobalService globalService = (IGlobalService)ctx.getBean("globalServiceImpl");
		context.setAttribute("webroot", "http://localhost:8080/loan");
		context.setAttribute("theme_dir", "/statics");
		context.setAttribute("admin", 1);
		//网站地址
		context.setAttribute("wangzhi", globalService.getAdById(17));
		//微博
		context.setAttribute("wb", globalService.getAdById(13));
		//微信
		context.setAttribute("wx", globalService.getAdById(14));
		//address
		context.setAttribute("address", globalService.getAdById(18));
		//qq
		context.setAttribute("qq", globalService.getQqByType(0));
		//QQ群
		context.setAttribute("qun", globalService.getQqByType(1));
		//400电话
		context.setAttribute("kefuphone", globalService.getQqByType(2));
				
		Pageable pageable = new Pageable();
		pageable.setPageSize(7);
		ArrayList<FriendDTO> friendlist = articleService.getFriendsList(pageable);
		context.setAttribute("friendlist", friendlist);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

}
