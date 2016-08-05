package com.loan.article.service.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.loan.article.dao.ArticleDao;
import com.loan.article.dto.ArticleCategoryDTO;
import com.loan.article.dto.ArticleDTO;
import com.loan.article.dto.FriendDTO;
import com.loan.article.dto.MediaDTO;
import com.loan.article.service.IArticleService;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;
@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private  ArticleDao articleDao;
	
	@Cacheable(value="myCache",key="'cts3'" )
	public List<String>  getlist(){
		List<String> list = new ArrayList<String>();
		try {
			Connection C = DriverManager.getConnection("jdbc:mysql://localhost/online_20160316?user=root&password=root");  
			Statement s=C.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
			ResultSet rs=s.executeQuery("select * from lzh_Article limit 10"); 
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	@Cacheable(value="myCache",key="'cts2'" )
	public List<String>  getlist123(){
		List<String> list = new ArrayList<String>();
		try {
			Connection C = DriverManager.getConnection("jdbc:mysql://localhost/online_20160316?user=root&password=root");  
			Statement s=C.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
			ResultSet rs=s.executeQuery("select * from lzh_Article limit 10"); 
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@Cacheable(value="myCache",key=  "'getArticleList'" )
	public PageList<ArticleDTO> getArticleList(ArticleDTO article,Pageable pageable) {
		return articleDao.getArticleList(article,pageable);
	}
	public int getArticleListCount(@Param("article")ArticleDTO article){
		return articleDao.getArticleListCount(article);
	}
	public PageList<MediaDTO> getMediasList(Pageable pageable){
		return articleDao.getMediasList(pageable);
	}
	public ArrayList<FriendDTO> getFriendsList(Pageable pageable){
		return articleDao.getFriendsList(pageable);
	}
	public ArticleDTO getArticleById(int id ){
		return articleDao.getArticleById(id);
	}
	//@CacheEvict(value="myCache", key="'cts38'")  
	@Cacheable(value="myCache",key=  "'getArticleCategoryListByPid'" )
	public ArrayList<ArticleCategoryDTO> getArticleCategoryListByPid(ArticleCategoryDTO articleCategoryDTO){
		return articleDao.getArticleCategoryListByPid(articleCategoryDTO);
	}
	@Cacheable(value="myCache",key=  "'Category'+#id" )
	public ArticleCategoryDTO getArticleCategoryByPid(int id){
		return articleDao.getArticleCategoryByPid(id);
	}
}
