/**
 * Copyright (C)  版权所有
 * 文件名： InvestServiceImpl.java
 * 包名： com.loan.invest.service
 * 说明：
 * @author admin
 * @date Apr 13, 2016 3:42:40 PM
 * @version V1.0
 */ 
package com.loan.invest.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.invest.dao.InvestDao;
import com.loan.invest.dto.Borrow_investorDTO;
import com.loan.invest.service.IInvestService;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： InvestServiceImpl
 * 描述：
 * @author admin
 * @date Apr 13, 2016 3:42:40 PM
 *
 *
 */
@Service
public class InvestServiceImpl implements IInvestService{
	
	@Autowired
	private InvestDao investDao;
	
	public String getInvestCapitalSum(@Param("id") int uid,@Param("bid") String bid){
		return investDao.getInvestCapitalSum(uid, bid);
	}
	public PageList<Borrow_investorDTO> getInvestRecordByBid(@Param("bid") String bid,Pageable pageable){
		return investDao.getInvestRecordByBid(bid,pageable);
	}
	public int getInvestRecordCount(@Param("bid") String bid){
		ArrayList<Borrow_investorDTO> list = null;
		int count = 0;
		try {
			list = investDao.getInvestRecordByBid(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null){
			count = list.size();
		}
		return count;
	}
}
