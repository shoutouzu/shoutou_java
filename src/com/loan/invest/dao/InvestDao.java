/**
 * Copyright (C)  版权所有
 * 文件名： InvestDao.java
 * 包名： com.loan.invest.dao
 * 说明：
 * @author admin
 * @date Apr 13, 2016 3:41:09 PM
 * @version V1.0
 */ 
package com.loan.invest.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.loan.invest.dto.Borrow_investorDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： InvestDao
 * 描述：
 * @author admin
 * @date Apr 13, 2016 3:41:09 PM
 *
 *
 */
public interface InvestDao {
	public String getInvestCapitalSum(@Param("uid") int uid,@Param("bid") String bid);
	public PageList<Borrow_investorDTO> getInvestRecordByBid(@Param("bid") String bid,Pageable pageable);
	public ArrayList<Borrow_investorDTO> getInvestRecordByBid(@Param("bid") String bid);
}
