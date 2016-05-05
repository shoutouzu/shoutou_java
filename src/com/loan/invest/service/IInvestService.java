/**
 * Copyright (C)  版权所有
 * 文件名： IInvestService.java
 * 包名： com.loan.invest
 * 说明：
 * @author admin
 * @date Apr 13, 2016 3:41:24 PM
 * @version V1.0
 */ 
package com.loan.invest.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.loan.invest.dto.Borrow_investorDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： IInvestService
 * 描述：
 * @author admin
 * @date Apr 13, 2016 3:41:24 PM
 *
 *
 */
public interface IInvestService {
	public String getInvestCapitalSum(@Param("id") int uid,@Param("bid") String bid);
	public PageList<Borrow_investorDTO> getInvestRecordByBid(@Param("bid") String bid,Pageable pageable);
	public int getInvestRecordCount(@Param("bid") String bid);
}
