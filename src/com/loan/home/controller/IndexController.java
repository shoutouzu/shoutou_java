package com.loan.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loan.article.dto.ArticleDTO;
import com.loan.article.dto.MediaDTO;
import com.loan.article.service.IArticleService;
import com.loan.borrow.dto.BorrowInfoDTO;
import com.loan.borrow.service.IBorrowService;
import com.loan.global.service.IGlobalService;
import com.loan.member.service.IMemberService;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

@Controller
@RequestMapping("index")
public class IndexController {
		
	protected final transient Log log = LogFactory.getLog(IndexController.class);
	@Autowired
	private IGlobalService globalService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IBorrowService borrowService;
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping
	public String index(ModelMap modelMap) {
		//网站公告
		ArticleDTO art = new ArticleDTO();
		art.setType_id(43);
		Pageable pageable = new Pageable();
		pageable.setPageSize(7);
		PageList<ArticleDTO> gonggao_list = articleService.getArticleList(art,pageable);
		modelMap.put("gonggaoList", gonggao_list);
		//新闻
		art = new ArticleDTO();
		pageable = new Pageable();
		art.setType_id(2);
		pageable.setPageSize(6);
		PageList<ArticleDTO> news_list = articleService.getArticleList(art,pageable);
		modelMap.put("news", news_list);
		//散标列表开始
		pageable = new Pageable();
		pageable.setPageSize(5);
		Map<String, Object> map = new HashMap<String, Object>();
		 int[] borrow_status = { 2,4,6,7 };  
		 int[] stock_type = { 1,2,3,4 };  
		map.put("borrow_status", borrow_status);
		map.put("stock_type", stock_type);
		map.put("borrow_duration", "");
		PageList<BorrowInfoDTO> borrowList = borrowService.getBorrowInfoList(map, pageable);
		modelMap.put("borrowList", borrowList);
		String[] progres=new String[borrowList.size()];
		ArrayList<String> pro = new ArrayList<String>();
		for(int i=0;i<borrowList.size();i++){
			BorrowInfoDTO borrInfoDTO = borrowList.get(i);
			double progress = borrInfoDTO.getHas_borrow()/borrInfoDTO.getBorrow_money()*100;
			progres[i] = String.valueOf(Math.round(progress));
			pro.add(String.valueOf(Math.round(progress)));
		}
		//累计会员人数
		int count = memberService.getMemberCount();
		modelMap.put("memberCount", count);
		
		modelMap.put("progress", pro);
		//客户赚取收益
		BorrowInfoDTO borrowInfoSum = borrowService.getSumInvestorProfit();
		modelMap.put("investorProfit", borrowInfoSum.getInvestor_profit());
		//成交金额
		modelMap.put("borrow_sum", borrowInfoSum.getBorrow_sum());
		//媒体报道
		pageable = new Pageable();
		pageable.setPageSize(7);
		PageList<MediaDTO> mediaList = articleService.getMediasList(pageable);
		modelMap.put("mediaList", mediaList);
		return "index";
	}
}
