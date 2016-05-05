/**
 * Copyright (C)  版权所有
 * 文件名： Borrow_investorDTO.java
 * 包名： com.loan.invest.dto
 * 说明：
 * @author admin
 * @date Apr 26, 2016 2:58:02 PM
 * @version V1.0
 */ 
package com.loan.invest.dto;
/**
 * 类名： Borrow_investorDTO
 * 描述：
 * @author admin
 * @date Apr 26, 2016 2:58:02 PM
 *
 *
 */
public class Borrow_investorDTO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4163979722966007799L;
	public int id;
	public int ent;
	public int borrow_interest_rate;
	public int repayment_type;
	public String add_time;
	public int is_auto;
	public String user_name;
	public int status;
	public int borrow_id;
	public int investor_uid;
	public double investor_capital;
	public double investor_interest;
	public double receive_capital;
	public double receive_interest;
	public double invest_fee;
	public String deadline;
	public int  debt_status;
	public int  debt_uid;
	public int is_first;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnt() {
		return ent;
	}
	public void setEnt(int ent) {
		this.ent = ent;
	}
	public int getBorrow_interest_rate() {
		return borrow_interest_rate;
	}
	public void setBorrow_interest_rate(int borrow_interest_rate) {
		this.borrow_interest_rate = borrow_interest_rate;
	}
	public int getRepayment_type() {
		return repayment_type;
	}
	public void setRepayment_type(int repayment_type) {
		this.repayment_type = repayment_type;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public int getIs_auto() {
		return is_auto;
	}
	public void setIs_auto(int is_auto) {
		this.is_auto = is_auto;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}
	public int getInvestor_uid() {
		return investor_uid;
	}
	public void setInvestor_uid(int investor_uid) {
		this.investor_uid = investor_uid;
	}
	public double getInvestor_capital() {
		return investor_capital;
	}
	public void setInvestor_capital(double investor_capital) {
		this.investor_capital = investor_capital;
	}
	public double getInvestor_interest() {
		return investor_interest;
	}
	public void setInvestor_interest(double investor_interest) {
		this.investor_interest = investor_interest;
	}
	public double getReceive_capital() {
		return receive_capital;
	}
	public void setReceive_capital(double receive_capital) {
		this.receive_capital = receive_capital;
	}
	public double getReceive_interest() {
		return receive_interest;
	}
	public void setReceive_interest(double receive_interest) {
		this.receive_interest = receive_interest;
	}
	public double getInvest_fee() {
		return invest_fee;
	}
	public void setInvest_fee(double invest_fee) {
		this.invest_fee = invest_fee;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public int getDebt_status() {
		return debt_status;
	}
	public void setDebt_status(int debt_status) {
		this.debt_status = debt_status;
	}
	public int getDebt_uid() {
		return debt_uid;
	}
	public void setDebt_uid(int debt_uid) {
		this.debt_uid = debt_uid;
	}
	public int getIs_first() {
		return is_first;
	}
	public void setIs_first(int is_first) {
		this.is_first = is_first;
	}
	
}
