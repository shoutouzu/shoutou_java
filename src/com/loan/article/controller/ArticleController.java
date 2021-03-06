/**
 * Copyright (C)  版权所有
 * 文件名： NoticeController.java
 * 包名： com.loan.article.controller
 * 说明：
 * @author admin
 * @date Apr 5, 2016 5:23:24 PM
 * @version V1.0
 */ 
package com.loan.article.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loan.article.dto.ArticleCategoryDTO;
import com.loan.article.dto.ArticleDTO;
import com.loan.article.service.IArticleService;
import com.loan.article.service.impl.ArticleServiceImpl;
import com.loan.test.UserService;
import com.loan.utils.Page;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： NoticeController
 * 描述：	公告
 * @author admin
 * @date Apr 5, 2016 5:23:24 PM
 *
 *
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private CacheManager cacheManager;
	
	 @Resource  
	    private UserService userService;  
	    
	      
	    @RequestMapping(value="/get/{userNo}", method=RequestMethod.GET)  
	    public String get(@PathVariable String userNo, Model model){  
	        String username = userService.get(userNo);  
	        model.addAttribute("username", username);  
	        System.out.println("cts1==========================="+cacheManager.getCache("myCache").get("get"+userNo));
	        return "getUser";  
	    }
	    
	@RequestMapping("gonggao1/{userNo}")
	public String gonggao1(@PathVariable String userNo){
		String username = userService.get(userNo);  
        System.out.println("cts111==========================="+cacheManager.getCache("myCache").get("get"+userNo));
        
		try {
			articleService.getlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("cts3==========================="+cacheManager.getCache("myCache").get("cts3"));
		return "gonggao/gonggao";
	}
	
	@RequestMapping("gonggao")
	public String gonggao(@RequestParam("flag")String flag,@RequestParam(value="page",required=true,defaultValue="1")int page,ModelMap modelMap){
		ArticleDTO article = new ArticleDTO();
		article.setType_id(article.getNid(flag));
		Pageable pageable = new Pageable(page,15);
		PageList<ArticleDTO> list  = articleService.getArticleList(article, pageable);
		modelMap.put("gonggaoList", list);
		ArticleCategoryDTO articleCategoryDTO = new ArticleCategoryDTO();
		articleCategoryDTO.setParent_id(9);
		ArrayList<ArticleCategoryDTO> listAc  = articleService.getArticleCategoryListByPid(articleCategoryDTO);
		modelMap.put("leftlist", listAc);
		ArticleCategoryDTO articleCategory = articleService.getArticleCategoryByPid(article.getNid(flag));
		modelMap.put("articleCategory", articleCategory);
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setType_id(article.getNid(flag)); 
		modelMap.put("articleDTO", articleDTO);
		Page pag = new Page(articleService.getArticleListCount(article), page,15);
		HashMap<Object,Object> map = new HashMap<Object,Object>();
		modelMap.put("page", pag);
		modelMap.put("list", list);
		modelMap.put("param", map);
		return "gonggao/gonggao";
	}
	@RequestMapping("view")
	public String view(@RequestParam("id")int id ,@RequestParam("type_id")int type_id,ModelMap modelMap){
		ArticleDTO articleDTO = articleService.getArticleById(id);
		modelMap.put("articleDTO", articleDTO);
		ArticleCategoryDTO articleCategory = articleService.getArticleCategoryByPid(type_id);
		modelMap.put("articleCategory", articleCategory);
		ArticleCategoryDTO articleCategoryDTO = new ArticleCategoryDTO();
		articleCategoryDTO.setParent_id(9);
		ArrayList<ArticleCategoryDTO> listAc  = articleService.getArticleCategoryListByPid(articleCategoryDTO);
		modelMap.put("leftlist", listAc);
		
		
		return "gonggao/view";
	}
	public static void main(String[] args) {
		String linkPage="";
		int  nowPage = 17;
		int rollPage = 8;
		int totallist =261;
		int pageno = 15;
		
		int totalPages = (int)Math.ceil((double)totallist/pageno);
		System.out.println(totalPages);
		String url="http://localhost";
		double result = (double)nowPage/rollPage;
		System.out.println(result);
		 int nowCoolPage      = (int)Math.ceil(result);
	        for(int i=1;i<=rollPage;i++){
	            int page=(nowCoolPage-1)*rollPage+i;
	            if(page!=nowPage){
	                if(page<=totalPages){
	                    linkPage += "&nbsp;<a href='"+url+"=$page{$idtagert}'>&nbsp;"+page+"&nbsp;</a>";
	                }else{
	                    break;
	                }
	            }else{
	                if(totalPages != 1){
	                    linkPage += "&nbsp;<span class='current'>c"+page+"</span>";
	                }
	            }
	        }
	        System.out.println(linkPage);
	}
}
