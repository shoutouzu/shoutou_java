package com.loan.Junit;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.loan.article.service.IArticleService;
import com.loan.borrow.service.IBorrowService;
import com.loan.invest.dto.Borrow_investorDTO;
import com.loan.invest.service.IInvestService;
import com.loan.member.service.IMemberService;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class TestMyBatis {
	@Autowired
	public IBorrowService borrowService;
	@Autowired
	private IMemberService member;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IInvestService investService;
	
	@Test
	public void test() {   
		try {
			/*BorrowInfoDTO borrowInfoDTO = new BorrowInfoDTO();
			borrowInfoDTO.setBorrow_status(1);
			borrowInfoDTO.setStock_type(1);
			Pageable pageable = new Pageable();
			pageable.setPageSize(7);
			PageList<BorrowInfoDTO> borrowList = borrowService.getBorrowInfoList(borrowInfoDTO, pageable);
			System.out.println(borrowService.getSumInvestorProfit()+"========="+borrowList.size());
			
			int count = member.getMemberCount();
			System.out.println(count +" Success****************************************************");*/
			
			/*borrowInfoDTO = borrowService.getSumInvestorProfit();
			System.err.println(borrowInfoDTO.getInvestor_profit());
			System.err.println(borrowInfoDTO.getBorrow_sum());
			ArticleDTO aaa = articleService.getArticleById(2704);
			System.out.println("====================="+aaa.getTitle());
			System.out.println("====================="+aaa.getArt_content());*/
			//散标列表开始
			/*BorrowInfoDTO borrowInfoDTO = new BorrowInfoDTO();
			Pageable pageable = new Pageable();
			pageable.setPageSize(5);
			borrowInfoDTO.setBorrow_status(1);
			borrowInfoDTO.setStock_type(0);
			borrowInfoDTO.setBorrow_status_1("2,4,6,7");
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put("borrow_status", "1");
//			map.put("stock_type", "4");
			 String[] borrow_status = { "2","4","6","7" };  
			 String[] stock_type = { "1","2","3","4" };  
			map.put("borrow_status", borrow_status);
			map.put("stock_type", stock_type);
			String borrow_duration="0-3-9";
			 map.put("borrow_duration", borrow_duration);
			 Map duration = GlobalUtils.getBorrowDurationMap();
			 if(!"".equals(borrow_duration)&&duration.containsKey(borrow_duration)){
				 String[] arr = borrow_duration.split("-");
					 map.put("borrow_duration_min", arr[0]);
					 map.put("borrow_duration_max", arr[1]);
			 }else{
				 map.remove("borrow_duration");
				 map.put("borrow_duration", "");
			 }
			PageList<BorrowInfoDTO> borrowList = borrowService.getBorrowInfoList(map, pageable);
			for(BorrowInfoDTO b:borrowList){
				System.out.println(b.getBorrow_name());
			}*/
			/*BorrowInfoDTO borrowInfoDTO = new BorrowInfoDTO();
			borrowInfoDTO  = borrowService.getBorrowInfoById("883");
			String date = borrowInfoDTO.getUpdata();
			try {
	 			List<Map<String, String>> list = (List)PHPSerializer.unserialize(date.getBytes());
	 			System.out.println(list.size());
	 			for(Map<String, String> map22:list){
	 				for (String s : map22.keySet()) {
	 					System.out.println("key:"+s+" 	 value:"+map22.get(s));
	 				}
	 			}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String reString = investService.getInvestCapitalSum(62, "892");
			System.out.println(reString);
			MemberMoneyDTO m = member.getMemberMoneyById(62);
			System.err.println(m.getAccount_money());
			*/
			Pageable pageable = new Pageable();
			pageable.setPageSize(5);
			pageable.setCurrentPage(2);
			int list = investService.getInvestRecordCount("846");
			System.err.println(31/10);
			int pages = (int)Math.ceil(((double)21 + 0.0D) / (double)10);
			System.out.println(pages);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
