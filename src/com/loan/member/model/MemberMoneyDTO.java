/**
 * Copyright (C)  版权所有
 * 文件名： MemberMoneyDTO.java
 * 包名： com.loan.member.model
 * 说明：
 * @author admin
 * @date Apr 18 2016 2:48:07 PM
 * @version V1.0
 */ 
package com.loan.member.model;

import java.io.Serializable;

/**
 * 类名： MemberMoneyDTO
 * 描述：
 * @author admin
 * @date Apr 18 2016 2:48:07 PM
 *
 *
 */
public class MemberMoneyDTO implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 7211681675508185030L;
	public int  uid;
	  public double money_freeze;//'冻结金额'
	  public double money_collect;//'待收金额'
	  public double account_money;// '充值资金存放池_可用余额'
	  public double back_money;// '回款资金存放池_可用余额'
	  public double credit_limit;// '信用总额度'
	  public double credit_cuse;// '已用信用额度'
	  public double borrow_vouch_limit;// '借款担保总额度'
	  public double borrow_vouch_cuse;// '借款担保已用额度'
	  public double invest_vouch_limit;// '投资担保总额度'
	  public double invest_vouch_cuse;// '投资担保已用额度'
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getMoney_freeze() {
		return money_freeze;
	}
	public void setMoney_freeze(double money_freeze) {
		this.money_freeze = money_freeze;
	}
	public double getMoney_collect() {
		return money_collect;
	}
	public void setMoney_collect(double money_collect) {
		this.money_collect = money_collect;
	}
	public double getAccount_money() {
		return account_money;
	}
	public void setAccount_money(double account_money) {
		this.account_money = account_money;
	}
	public double getBack_money() {
		return back_money;
	}
	public void setBack_money(double back_money) {
		this.back_money = back_money;
	}
	public double getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(double credit_limit) {
		this.credit_limit = credit_limit;
	}
	public double getCredit_cuse() {
		return credit_cuse;
	}
	public void setCredit_cuse(double credit_cuse) {
		this.credit_cuse = credit_cuse;
	}
	public double getBorrow_vouch_limit() {
		return borrow_vouch_limit;
	}
	public void setBorrow_vouch_limit(double borrow_vouch_limit) {
		this.borrow_vouch_limit = borrow_vouch_limit;
	}
	public double getBorrow_vouch_cuse() {
		return borrow_vouch_cuse;
	}
	public void setBorrow_vouch_cuse(double borrow_vouch_cuse) {
		this.borrow_vouch_cuse = borrow_vouch_cuse;
	}
	public double getInvest_vouch_limit() {
		return invest_vouch_limit;
	}
	public void setInvest_vouch_limit(double invest_vouch_limit) {
		this.invest_vouch_limit = invest_vouch_limit;
	}
	public double getInvest_vouch_cuse() {
		return invest_vouch_cuse;
	}
	public void setInvest_vouch_cuse(double invest_vouch_cuse) {
		this.invest_vouch_cuse = invest_vouch_cuse;
	}
	  
}
