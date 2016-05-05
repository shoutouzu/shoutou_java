/**
 * Copyright (C)  版权所有
 * 文件名： IBorrowService.java
 * 包名： com.loan.borrow.service
 * 说明：
 * @author admin
 * @date Mar 24, 2016 10:16:48 AM
 * @version V1.0
 */ 
package com.loan.borrow.service;

import java.util.Map;

import com.loan.borrow.dto.BorrowInfoDTO;
import com.loan.utils.mybatis.paginator.PageList;
import com.loan.utils.mybatis.paginator.Pageable;

/**
 * 类名： IBorrowService
 * 描述：
 * @author admin
 * @date Mar 24, 2016 10:16:48 AM
 *
 *
 */
public interface IBorrowService {
	/**
	 * 
	 * 方法描述：查询借款标列表 
	 * @param borrowInfoDTO 借款信息实体
	 * @param pageable 分页实体
	 * @return
	 * PageList<BorrowInfoDTO>
	 * @author admin
	 * @date Mar 25, 2016 2:03:07 PM
	 */
	public PageList<BorrowInfoDTO> getBorrowInfoList(Map<String, Object> map,Pageable pageable);
	/**
	 * 
	 * 方法描述： 借款详情
	 * @param bid
	 * @return
	 * BorrowInfoDTO
	 * @author admin
	 * @date Apr 13, 2016 3:02:10 PM
	 */
	public BorrowInfoDTO getBorrowInfoById(String bid);
	/**
	 * 
	 * 方法描述： 查询理财收益
	 * @return
	 * String
	 * @author admin
	 * @date Mar 25, 2016 2:03:49 PM
	 */
	public BorrowInfoDTO getSumInvestorProfit();
}
