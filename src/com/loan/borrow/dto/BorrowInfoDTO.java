/**
 * Copyright (C)  版权所有
 * 文件名： BorrowInfoDTO.java
 * 包名： com.loan.borrow
 * 说明：
 * @author admin
 * @date Mar 24, 2016 10:15:17 AM
 * @version V1.0
 */ 
package com.loan.borrow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class BorrowInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3630922697078231376L;
	public int id;
	public String borrow_name;
	public int money_invest_place;
	public int borrow_type;
	public int stock_type;
	public int reward_type;
	public String borrow_times;
	public int borrow_status;
	public double borrow_money;
	public int borrow_use;
	public int repayment_type;
	public String borrow_interest_rate;
	public int borrow_duration;
	public String collect_time;
	public String  add_time;
	public int  province;
	public double  has_borrow;
	public String  has_vouch;
	public int  city;
	public int  area;
	public double  reward_num;
	public String  password;
	public String  is_tuijian;
	public int  deadline;
	public String  danbao;
	public String  borrow_info;
	public String  risk_control;
	public String  investor_profit;//客户理财收益
	public String  borrow_sum;//借款总额
	public String  borrow_status_1;
	public String updata;
	public double borrow_max;
	public double borrow_min;
	public double need;//剩余可投
	public double needc;
	public String first_verify_time;
	public String capital_name;
	public String capital_card;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBorrow_name() {
		return borrow_name;
	}
	public void setBorrow_name(String borrow_name) {
		this.borrow_name = borrow_name;
	}
	public int getMoney_invest_place() {
		return money_invest_place;
	}
	public void setMoney_invest_place(int money_invest_place) {
		this.money_invest_place = money_invest_place;
	}
	public int getBorrow_type() {
		return borrow_type;
	}
	public void setBorrow_type(int borrow_type) {
		this.borrow_type = borrow_type;
	}
	public int getStock_type() {
		return stock_type;
	}
	public void setStock_type(int stock_type) {
		this.stock_type = stock_type;
	}
	public int getReward_type() {
		return reward_type;
	}
	public void setReward_type(int reward_type) {
		this.reward_type = reward_type;
	}
	public String getBorrow_times() {
		return borrow_times;
	}
	public void setBorrow_times(String borrow_times) {
		this.borrow_times = borrow_times;
	}
	public int getBorrow_status() {
		return borrow_status;
	}
	public void setBorrow_status(int borrow_status) {
		this.borrow_status = borrow_status;
	}
	public double getBorrow_money() {
		return borrow_money;
	}
	public void setBorrow_money(double borrow_money) {
		this.borrow_money = borrow_money;
	}
	public int getBorrow_use() {
		return borrow_use;
	}
	public void setBorrow_use(int borrow_use) {
		this.borrow_use = borrow_use;
	}
	public int getRepayment_type() {
		return repayment_type;
	}
	public void setRepayment_type(int repayment_type) {
		this.repayment_type = repayment_type;
	}
	public String getBorrow_interest_rate() {
		return borrow_interest_rate;
	}
	public void setBorrow_interest_rate(String borrow_interest_rate) {
		this.borrow_interest_rate = borrow_interest_rate;
	}
	public int getBorrow_duration() {
		return borrow_duration;
	}
	public void setBorrow_duration(int borrow_duration) {
		this.borrow_duration = borrow_duration;
	}
	public String getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(String collect_time) {
		this.collect_time = collect_time;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public double getHas_borrow() {
		return has_borrow;
	}
	public void setHas_borrow(double has_borrow) {
		this.has_borrow = has_borrow;
	}
	public String getHas_vouch() {
		return has_vouch;
	}
	public void setHas_vouch(String has_vouch) {
		this.has_vouch = has_vouch;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public double getReward_num() {
		return reward_num;
	}
	public void setReward_num(double reward_num) {
		this.reward_num = reward_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIs_tuijian() {
		return is_tuijian;
	}
	public void setIs_tuijian(String is_tuijian) {
		this.is_tuijian = is_tuijian;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public String getDanbao() {
		return danbao;
	}
	public void setDanbao(String danbao) {
		this.danbao = danbao;
	}
	public String getBorrow_info() {
		return borrow_info;
	}
	public void setBorrow_info(String borrow_info) {
		this.borrow_info = borrow_info;
	}
	public String getRisk_control() {
		return risk_control;
	}
	public void setRisk_control(String risk_control) {
		this.risk_control = risk_control;
	}
	public String getInvestor_profit() {
		return investor_profit;
	}
	public void setInvestor_profit(String investor_profit) {
		this.investor_profit = investor_profit;
	}
	public String getBorrow_sum() {
		return borrow_sum;
	}
	public void setBorrow_sum(String borrow_sum) {
		this.borrow_sum = borrow_sum;
	}
	public String getBorrow_status_1() {
		return borrow_status_1;
	}
	public void setBorrow_status_1(String borrow_status_1) {
		this.borrow_status_1 = borrow_status_1;
	}
	public String getUpdata() {
		return updata;
	}
	public void setUpdata(String updata) {
		this.updata = updata;
	}
	public double getBorrow_max() {
		return borrow_max;
	}
	public void setBorrow_max(double borrow_max) {
		this.borrow_max = borrow_max;
	}
	public double getBorrow_min() {
		return borrow_min;
	}
	public void setBorrow_min(double borrow_min) {
		this.borrow_min = borrow_min;
	}
	public double getNeed() {
		return need;
	}
	public void setNeed(double need) {
		this.need = need;
	}
	public double getNeedc() {
		return needc;
	}
	public void setNeedc(double needc) {
		this.needc = needc;
	}
	public String getFirst_verify_time() {
		return first_verify_time;
	}
	public void setFirst_verify_time(String first_verify_time) {
		this.first_verify_time = first_verify_time;
	}
	
}
