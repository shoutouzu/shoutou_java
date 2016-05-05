/**
 * Copyright (C)  版权所有
 * 文件名： QqDTO.java
 * 包名： com.loan.global.dto
 * 说明：
 * @author admin
 * @date Apr 26, 2016 5:54:16 PM
 * @version V1.0
 */ 
package com.loan.global.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 类名： QqDTO
 * 描述：
 * @author admin
 * @date Apr 26, 2016 5:54:16 PM
 *
 *
 */
public class QqDTO {
	public int id;
	public String qq_num;
	public String qq_title;
	public int qq_order;
	public int is_show;
	public int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQq_num() {
		return qq_num;
	}
	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}
	public String getQq_title() {
		return qq_title;
	}
	public void setQq_title(String qq_title) {
		this.qq_title = qq_title;
	}
	public int getQq_order() {
		return qq_order;
	}
	public void setQq_order(int qq_order) {
		this.qq_order = qq_order;
	}
	public int getIs_show() {
		return is_show;
	}
	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
