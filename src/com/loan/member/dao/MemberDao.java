/**
 * Copyright (C)  版权所有
 * 文件名： MemberDao.java
 * 包名： com.loan.member.dao
 * 说明：
 * @author admin
 * @date Mar 24, 2016 5:35:15 PM
 * @version V1.0
 */ 
package com.loan.member.dao;

import com.loan.member.model.MemberMoneyDTO;

/**
 * 类名： MemberDao
 * 描述：
 * @author admin
 * @date Mar 24, 2016 5:35:15 PM
 *
 *
 */
public interface MemberDao {
	/**
	 * 
	 * 方法描述： 
	 * @return
	 * int
	 * @author admin
	 * @date Mar 24, 2016 5:35:32 PM
	 */
	public int getMemberCount();
	public MemberMoneyDTO getMemberMoneyById(int uid);
}
