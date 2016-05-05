/**
 * Copyright (C)  版权所有
 * 文件名： BorrowInfoDao.java
 * 包名： com.loan.borrow.dao
 * 说明：
 * @author admin
 * @date Mar 24, 2016 10:32:13 AM
 * @version V1.0
 */ 
package com.loan.borrow.dao;

import java.util.Map;

import com.loan.borrow.dto.BorrowInfoDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： BorrowInfoDao
 * 描述：
 * @author admin
 * @date Mar 24, 2016 10:32:13 AM
 *
 *
 */
public interface BorrowInfoDao {
	public PageList<BorrowInfoDTO> getBorrowInfoList(Map<String, Object> map,Pageable pageable);
	public BorrowInfoDTO getBorrowInfoById(int bid);
	public BorrowInfoDTO getSumInvestorProfit();
}
