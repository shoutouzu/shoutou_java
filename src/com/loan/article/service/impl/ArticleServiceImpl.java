package com.loan.article.service.impl;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ArrayList<ArticleCategoryDTO> getArticleCategoryListByPid(ArticleCategoryDTO articleCategoryDTO){
		return articleDao.getArticleCategoryListByPid(articleCategoryDTO);
	}
	public ArticleCategoryDTO getArticleCategoryByPid(int id){
		return articleDao.getArticleCategoryByPid(id);
	}
}
