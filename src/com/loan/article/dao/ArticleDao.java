package com.loan.article.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;


import com.loan.article.dto.ArticleCategoryDTO;
import com.loan.article.dto.ArticleDTO;
import com.loan.article.dto.FriendDTO;
import com.loan.article.dto.MediaDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

public interface ArticleDao {
	public PageList<ArticleDTO> getArticleList(@Param("article")ArticleDTO article,Pageable pageable);
	public int getArticleListCount(@Param("article")ArticleDTO article);
	public PageList<MediaDTO> getMediasList(Pageable pageable);
	public ArrayList<FriendDTO> getFriendsList(Pageable pageable);
	public ArticleDTO getArticleById(int id );
	public ArrayList<ArticleCategoryDTO> getArticleCategoryListByPid(@Param("articleCategoryDTO")ArticleCategoryDTO articleCategoryDTO);
	public ArticleCategoryDTO getArticleCategoryByPid(int id);
}
