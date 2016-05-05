package com.loan.article.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.loan.article.dto.ArticleCategoryDTO;
import com.loan.article.dto.ArticleDTO;
import com.loan.article.dto.FriendDTO;
import com.loan.article.dto.MediaDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

public interface IArticleService {
	/**
	 * 
	 * 方法描述：获取文章列表 
	 * @param article
	 * @param pageable
	 * @return
	 * PageList<Article>
	 * @author admin
	 * @date Mar 25, 2016 2:24:20 PM
	 */
	public PageList<ArticleDTO> getArticleList(ArticleDTO article,Pageable pageable);
	/**
	 * 
	 * 方法描述：查询文章总数 
	 * @param article
	 * @return
	 * int
	 * @author admin
	 * @date Apr 7, 2016 11:48:55 AM
	 */
	public int getArticleListCount(@Param("article")ArticleDTO article);
	/**
	 * 
	 * 方法描述：	获取媒体报道 
	 * @param pageable
	 * @return
	 * PageList<Media>
	 * @author admin
	 * @date Mar 25, 2016 2:24:43 PM
	 */
	public PageList<MediaDTO> getMediasList(Pageable pageable);
	/**
	 * 
	 * 方法描述： 获取友情链接
	 * @param pageable
	 * @return
	 * ArrayList<Friend>
	 * @author admin
	 * @date Mar 31, 2016 10:37:52 AM
	 */
	public ArrayList<FriendDTO> getFriendsList(Pageable pageable);
	/**
	 * 
	 * 方法描述： 根据ID查询文章信息
	 * @param article
	 * @return
	 * ArticleDTO
	 * @author admin
	 * @date Apr 5, 2016 5:33:08 PM
	 */
	public ArticleDTO getArticleById(int id);
	/**
	 * 
	 * 方法描述： 根本父ID查询子列表
	 * @param articleCategoryDTO
	 * @return
	 * ArrayList<ArticleCategoryDTO>
	 * @author admin
	 * @date Apr 6, 2016 10:58:39 AM
	 */
	public ArrayList<ArticleCategoryDTO> getArticleCategoryListByPid(ArticleCategoryDTO articleCategoryDTO);
	/**
	 * 
	 * 方法描述： 根据Id查询栏目信息
	 * @param id
	 * @return
	 * ArticleCategoryDTO
	 * @author admin
	 * @date Apr 6, 2016 2:43:10 PM
	 */
	public ArticleCategoryDTO getArticleCategoryByPid(int id);

}
