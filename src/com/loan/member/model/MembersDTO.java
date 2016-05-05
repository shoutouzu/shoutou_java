/**
 * Copyright (C)  版权所有
 * 文件名： MembersDTO.java
 * 包名： com.loan.member.model
 * 说明：
 * @author admin
 * @date Apr 18, 2016 2:47:55 PM
 * @version V1.0
 */ 
package com.loan.member.model;

import java.io.Serializable;

/**
 * 类名： MembersDTO
 * 描述：
 * @author admin
 * @date Apr 18, 2016 2:47:55 PM
 *
 *
 */
public class MembersDTO implements Serializable{
		  /**
	 * 
	 */
	private static final long serialVersionUID = -1541447018828722266L;
		public int  id;
          public String user_name;
          public String user_pass;
          public int user_type;
          public String pin_pass;
          public String user_email;
          public String user_phone;
          public String reg_time;
          public String reg_ip;
          public int user_leve;
          public String time_limit;
          public int credits;
          public int recommend_id;
          public int customer_id;
          public String customer_name;
          public int province;
          public int city;
          public int area;
          public int is_ban;
          public double reward_money;
          public double invest_credits;
          public int integral;
          public int active_integral;
          public int is_borrow;
          public int is_transfer;
          public int is_vip;
          public String last_log_ip;
          public String last_log_time;
          public int tid;
          public int ent;
          public String sign_type;
          public String accountid;
          public String sign_base64;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getUser_pass() {
			return user_pass;
		}
		public void setUser_pass(String user_pass) {
			this.user_pass = user_pass;
		}
		public int getUser_type() {
			return user_type;
		}
		public void setUser_type(int user_type) {
			this.user_type = user_type;
		}
		public String getPin_pass() {
			return pin_pass;
		}
		public void setPin_pass(String pin_pass) {
			this.pin_pass = pin_pass;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getUser_phone() {
			return user_phone;
		}
		public void setUser_phone(String user_phone) {
			this.user_phone = user_phone;
		}
		public String getReg_time() {
			return reg_time;
		}
		public void setReg_time(String reg_time) {
			this.reg_time = reg_time;
		}
		public String getReg_ip() {
			return reg_ip;
		}
		public void setReg_ip(String reg_ip) {
			this.reg_ip = reg_ip;
		}
		public int getUser_leve() {
			return user_leve;
		}
		public void setUser_leve(int user_leve) {
			this.user_leve = user_leve;
		}
		public String getTime_limit() {
			return time_limit;
		}
		public void setTime_limit(String time_limit) {
			this.time_limit = time_limit;
		}
		public int getCredits() {
			return credits;
		}
		public void setCredits(int credits) {
			this.credits = credits;
		}
		public int getRecommend_id() {
			return recommend_id;
		}
		public void setRecommend_id(int recommend_id) {
			this.recommend_id = recommend_id;
		}
		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public int getProvince() {
			return province;
		}
		public void setProvince(int province) {
			this.province = province;
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
		public int getIs_ban() {
			return is_ban;
		}
		public void setIs_ban(int is_ban) {
			this.is_ban = is_ban;
		}
		public double getReward_money() {
			return reward_money;
		}
		public void setReward_money(double reward_money) {
			this.reward_money = reward_money;
		}
		public double getInvest_credits() {
			return invest_credits;
		}
		public void setInvest_credits(double invest_credits) {
			this.invest_credits = invest_credits;
		}
		public int getIntegral() {
			return integral;
		}
		public void setIntegral(int integral) {
			this.integral = integral;
		}
		public int getActive_integral() {
			return active_integral;
		}
		public void setActive_integral(int active_integral) {
			this.active_integral = active_integral;
		}
		public int getIs_borrow() {
			return is_borrow;
		}
		public void setIs_borrow(int is_borrow) {
			this.is_borrow = is_borrow;
		}
		public int getIs_transfer() {
			return is_transfer;
		}
		public void setIs_transfer(int is_transfer) {
			this.is_transfer = is_transfer;
		}
		public int getIs_vip() {
			return is_vip;
		}
		public void setIs_vip(int is_vip) {
			this.is_vip = is_vip;
		}
		public String getLast_log_ip() {
			return last_log_ip;
		}
		public void setLast_log_ip(String last_log_ip) {
			this.last_log_ip = last_log_ip;
		}
		public String getLast_log_time() {
			return last_log_time;
		}
		public void setLast_log_time(String last_log_time) {
			this.last_log_time = last_log_time;
		}
		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}
		public int getEnt() {
			return ent;
		}
		public void setEnt(int ent) {
			this.ent = ent;
		}
		public String getSign_type() {
			return sign_type;
		}
		public void setSign_type(String sign_type) {
			this.sign_type = sign_type;
		}
		public String getAccountid() {
			return accountid;
		}
		public void setAccountid(String accountid) {
			this.accountid = accountid;
		}
		public String getSign_base64() {
			return sign_base64;
		}
		public void setSign_base64(String sign_base64) {
			this.sign_base64 = sign_base64;
		}
          
}
