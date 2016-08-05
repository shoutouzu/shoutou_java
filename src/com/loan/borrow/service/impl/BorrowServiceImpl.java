/**
 * Copyright (C)  版权所有
 * 文件名： BorrowServiceImpl.java
 * 包名： com.loan.borrow.service.impl
 * 说明：
 * @author admin
 * @date Mar 24, 2016 10:58:14 AM
 * @version V1.0
 */ 
package com.loan.borrow.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.loan.borrow.dao.BorrowInfoDao;
import com.loan.borrow.dto.BorrowInfoDTO;
import com.loan.borrow.service.IBorrowService;
import com.loan.utils.StringUtil;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： BorrowServiceImpl
 * 描述：
 * @author admin
 * @date Mar 24, 2016 10:58:14 AM
 *
 *
 */
@Service
public class BorrowServiceImpl implements IBorrowService{
	@Autowired
	private BorrowInfoDao borrowInfoDao;
	/**
	 * 
	 * 方法描述： 
	 * @return
	 * ArrayList<BorrowInfoDTO>
	 * @author admin
	 * @date Mar 24, 2016 10:58:39 AM
	 */
	@Cacheable(value="myCache",key=  "'getBorrowInfoList'" )
	public PageList<BorrowInfoDTO> getBorrowInfoList(Map<String, Object> map,Pageable pageable){
		return borrowInfoDao.getBorrowInfoList(map,pageable);
	}
	public BorrowInfoDTO getBorrowInfoById(String bid){
		int id = 0;
		if(!StringUtil.isEmpty(bid)){
			id = Integer.valueOf(bid);
		}
		return borrowInfoDao.getBorrowInfoById(id);
	}
	public BorrowInfoDTO getSumInvestorProfit(){
		return borrowInfoDao.getSumInvestorProfit();
	}
}
