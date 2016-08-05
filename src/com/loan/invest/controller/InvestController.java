/**
 * Copyright (C)  版权所有
 * 文件名： InvestController.java
 * 包名： com.loan.invest.controller
 * 说明：
 * @author admin
 * @date Apr 8, 2016 10:48:33 AM
 * @version V1.0
 */ 
package com.loan.invest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loan.borrow.dto.BorrowInfoDTO;
import com.loan.borrow.service.IBorrowService;
import com.loan.global.controller.BaseController;
import com.loan.invest.dto.Borrow_investorDTO;
import com.loan.invest.service.IInvestService;
import com.loan.member.model.MemberMoneyDTO;
import com.loan.member.service.IMemberService;
import com.loan.utils.DateUtils;
import com.loan.utils.GlobalUtils;
import com.loan.utils.PHPSerializer;
import com.loan.utils.Page;
import com.loan.utils.ReturnEntity;
import com.loan.utils.StringUtil;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： InvestController
 * 描述：
 * @author admin
 * @date Apr 8, 2016 10:48:33 AM
 *
 *
 */
@Controller
@RequestMapping("invest")
public class InvestController extends BaseController{
	protected final transient Log log = LogFactory.getLog(InvestController.class);
	
	@Autowired
	private IBorrowService borrowService;
	@Autowired
	private IInvestService investService;
	@Autowired
	private IMemberService memberService;
	
	
	@RequestMapping("index")
	public String index(ModelMap modelMap,@RequestParam(value="stock_type",defaultValue="")String stock_type,
			@RequestParam(value="borrow_status",defaultValue="")String borrow_status,@RequestParam(value="borrow_duration",defaultValue="") String borrow_duration,@RequestParam(value="page",required=true,defaultValue="1")int page){
		//散标列表开始
		Pageable pageable = new Pageable(page,10);;
		Map<String, Object> map = new HashMap<String, Object>();
		
		 int[] borrow_status_arr = { 2,4,6,7 };  
		 int[] stock_type_arr = { 1,2,3,4 };  
		 if("".equals(borrow_status)){
			 borrow_status_arr = new int[]{ 2,4,6,7 };
		 }else{
			 borrow_status_arr = new int[]{Integer.valueOf(borrow_status)};
		 }
		 if("".equals(stock_type)){
			 stock_type_arr = new int[]{ 1,2,3,4 };
		 }else{
			 stock_type_arr = new int[]{Integer.valueOf(stock_type)};
		 }
		 Map<String,String> durationMap = GlobalUtils.getBorrowDurationMap();
		 Map<String,String> statusMap = GlobalUtils.getBorrowStatusMap();
		 Map<String,String> stockTypeMap = GlobalUtils.getStockTypeMap();
		 if(!"".equals(borrow_duration)&&durationMap.containsKey(borrow_duration)){
			 String[] arr = borrow_duration.split("-");
				 map.put("borrow_duration_min", arr[0]);
				 map.put("borrow_duration_max", arr[1]);
		 }else{
			 map.remove("borrow_duration");
			 map.put("borrow_duration", "");
		 }
			 
		map.put("borrow_status", borrow_status_arr);
		map.put("stock_type", stock_type_arr);
		
		PageList<BorrowInfoDTO> borrowList = borrowService.getBorrowInfoList(map, pageable);
		String[] progres=new String[borrowList.size()];
		ArrayList<String> pro = new ArrayList<String>();
		for(int i=0;i<borrowList.size();i++){
			BorrowInfoDTO borrInfoDTO = borrowList.get(i);
			double progress = borrInfoDTO.getHas_borrow()/borrInfoDTO.getBorrow_money()*100;
			progres[i] = String.valueOf(Math.round(progress));
			pro.add(String.valueOf(Math.round(progress)));
		}
		modelMap.put("progress", pro);
		modelMap.put("borrowList", borrowList);
		modelMap.put("durationMap", durationMap);
		modelMap.put("statusMap", statusMap);
		modelMap.put("stockTypeMap", stockTypeMap);
		Map<String,Object> search = new HashMap<String, Object>();
		search.put("duration", borrow_duration);
		search.put("status", borrow_status);
		search.put("stockType", stock_type);
		modelMap.put("search", search);
		return "invest/index";
	}
	@RequestMapping("detail")
	public String detail(ModelMap modelMap,@RequestParam(value="id",defaultValue="") String id){
		if("".equals(id)){
			return "error/404";
		}
		BorrowInfoDTO borrowInfoDTO = borrowService.getBorrowInfoById(id);
		if(borrowInfoDTO==null){
			return "error/404";
		}
		
		
		try {
			List<Map<String, String>> imgs_list = null;
			if(borrowInfoDTO.getUpdata()!=null && !"".equals(borrowInfoDTO.getUpdata())){
				imgs_list = (List)PHPSerializer.unserialize(borrowInfoDTO.getUpdata().getBytes());
			}
			
			modelMap.put("imgs", imgs_list);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		}
		//是否登录
		int uid = 62;
		double capital = 0;
		String invsx = "";
		if(1==1){
			String capital_t = investService.getInvestCapitalSum(uid, id);
			if(!StringUtil.isEmpty(capital_t)){
				capital = Double.valueOf(capital);
			}
			invsx = "no";
		}else{
			invsx = "yes";
		}
		modelMap.put("invid", invsx);
		//剩余可投金额
		double need = borrowInfoDTO.getBorrow_money() - borrowInfoDTO.getHas_borrow();
		borrowInfoDTO.setNeed(need);
		double myneed=0;
		if(borrowInfoDTO.getBorrow_max()>0){
			myneed = borrowInfoDTO.getBorrow_max()-capital;
		}else{
			myneed = need<borrowInfoDTO.getBorrow_min()?borrowInfoDTO.getBorrow_money():need;
		}
		MemberMoneyDTO memberMoneyDTO = memberService.getMemberMoneyById(uid);
		//账户资金情况
		modelMap.put("memberMoney", memberMoneyDTO);
		double myacc = memberMoneyDTO.getAccount_money() + memberMoneyDTO.getBack_money();
		double needc = 0;//能投多少
		if(myneed>myacc){
			needc = myacc;
		}else{
			needc = myneed;
		}
		if(borrowInfoDTO.getBorrow_max()>0){
			needc = borrowInfoDTO.getBorrow_max();
		}
		borrowInfoDTO.setNeedc(need);
		long lefttime = Long.valueOf(borrowInfoDTO.getCollect_time())-new Date().getTime();
		modelMap.put("lefttime", lefttime);
		double progress = borrowInfoDTO.getHas_borrow()/borrowInfoDTO.getBorrow_money()*100;
		String progres = String.valueOf(Math.round(progress));
		modelMap.put("progres", progres);
		modelMap.put("repaytype", GlobalUtils.getRepayType(borrowInfoDTO.getRepayment_type()));
		modelMap.put("borrowinfo", borrowInfoDTO);
		modelMap.put("borrow_id", id);
		Map<String,String> statusMap = GlobalUtils.getBorrowStatusMap();
		modelMap.put("statusMap", statusMap);
		return "invest/detail";
	}
	@RequestMapping(value="investRecord",produces={"application/json; charset=UTF-8"})
	public Object investRecord(@RequestParam(value="pageno",defaultValue="1")int pageno,@RequestParam(value="bid",defaultValue="")String bid){
		StringBuffer sb = new StringBuffer();
		Pageable pageable = new Pageable(pageno,10);
		PageList<Borrow_investorDTO> list = null;
		try {
			list=investService.getInvestRecordByBid(bid, pageable);
		} catch (Exception e) {
			return responseJson(false, e.getMessage(), Integer.valueOf(0), HttpStatus.FORBIDDEN);
		}
		if(list==null ||list.size()==0){
			return responseJson(false, "没有投资记录", Integer.valueOf(0), HttpStatus.OK);
		}
		for(int i=0;i<list.size();i++){
			Borrow_investorDTO investDTO = list.get(i);
			int  relult = i % 2;
			if (relult==0) {
               sb.append("<tr class='h_tdblue'><td width='148' class='txtC'>"+investDTO.getUser_name()+"</td>");
            } else {
            	 sb.append("<tr ><td width='148' class='txtC'>"+investDTO.getUser_name()+"</td>");
            }
			
			sb.append("<td width='148' class='txtC"+(investDTO.getEnt()>0 ? "new_add" : "")+"'>");
            if(investDTO.getEnt()>0){
                sb.append("<em class='new_wechat_tit'>微信</em><i class='new_wechat' data-id='"+i+"'></i>");
                sb.append("<p class='sweep_wechat' style='display: none;' id='sweep_wechat_"+i+">");
                sb.append("<em class='point1'></em>");
                sb.append("<img src='/Style/img/wechat.jpg' width='140' height='138'>");
                sb.append("<span class='sweep_wechat_con'>扫码注册领<i>百元</i>红包</span>");
                sb.append("<span class='sweep_wechat_con'>微信投标享<i>干二</i>奖励</span></p>");
			}else{
				sb.append(investDTO.getIs_auto()>0 ? "自动" : "手动");
			}
            sb.append("</td>");
            sb.append("<td  width='128' class='txtRight pr30'>" + investDTO.getInvestor_capital() + "元</td>");
            sb.append("<td width='198' class='txtC'>" +DateUtils.dateStr4(investDTO.getAdd_time())+ "</td>");
            sb.append("<td></td></tr>");
		}
		int count = investService.getInvestRecordCount(bid);
		Page page = new Page(count,pageno);
		sb.append("<tr>");
		sb.append(" <td style='padding: 0 10px; background: #f5f5f5; border: 1px solid #ececec;' colspan='4' align='left'>共 "+page.getPages()+" 页 &nbsp;");
		for(int m=1;m<=page.getPages();m++){
			sb.append("<a href='javascript:void(0);' onclick='ajax_show("+m+")'>&nbsp;"+m+"&nbsp;</a>&nbsp;");
		}
		sb.append("</tr>");
		return responseJson(true, sb.toString(), Integer.valueOf(0), HttpStatus.OK);
	}
}
