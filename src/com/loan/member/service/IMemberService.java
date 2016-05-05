/**
 * Copyright (C)  版权所有
 * 文件名： MemberService.java
 * 包名： com.loan.member.service
 * 说明：
 * @author admin
 * @date Mar 24, 2016 5:35:55 PM
 * @version V1.0
 */ 
package com.loan.member.service;

import com.loan.member.model.MemberMoneyDTO;

/**
 * 类名： MemberService
 * 描述：
 * @author admin
 * @date Mar 24, 2016 5:35:55 PM
 *
 *
 */
public interface IMemberService {
	/**
	 * 
	 * 方法描述：获取用户总数 
	 * @return
	 * int
	 * @author admin
	 * @date Mar 24, 2016 5:36:05 PM
	 */
	public int getMemberCount();
	public MemberMoneyDTO getMemberMoneyById(int uid);
}
