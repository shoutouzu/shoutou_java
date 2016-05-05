/**
 * Copyright (C)  版权所有
 * 文件名： MemberServiceImpl.java
 * 包名： com.loan.member.service.impl
 * 说明：
 * @author admin
 * @date Mar 24, 2016 5:36:37 PM
 * @version V1.0
 */ 
package com.loan.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.member.dao.MemberDao;
import com.loan.member.model.MemberMoneyDTO;
import com.loan.member.service.IMemberService;

/**
 * 类名： MemberServiceImpl
 * 描述：
 * @author admin
 * @date Mar 24, 2016 5:36:37 PM
 *
 *
 */
@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired
	public MemberDao memberDao;
	@Override
	public int getMemberCount() {
		return memberDao.getMemberCount();
	}
	public MemberMoneyDTO getMemberMoneyById(int uid){
		return memberDao.getMemberMoneyById(uid);
	}
}
