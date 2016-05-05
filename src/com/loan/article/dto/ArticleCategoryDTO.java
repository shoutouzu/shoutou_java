/**
 * Copyright (C)  版权所有
 * 文件名： ArticleCategoryDTO.java
 * 包名： com.loan.article.dto
 * 说明：
 * @author admin
 * @date Apr 6;public String  2016 10:51:18 AM
 * @version V1.0
 */ 
package com.loan.article.dto;
/**
 * 类名： ArticleCategoryDTO
 * 描述：
 * @author admin
 * @date Apr 6, 2016 10:51:18 AM
 *
 *
 */
public class ArticleCategoryDTO implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4462653172181386875L;
	public int id;
	public String type_name;
	public String type_url;
	public String type_keyword;
	public String type_info;
	public String type_content;
	public int sort_order;
	public int type_set;
	public String type_nid;
	public int is_hiden;
	public int  add_time;
	public int is_sys;
	public String model;
	public int   parent_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getType_url() {
		return type_url;
	}
	public void setType_url(String type_url) {
		this.type_url = type_url;
	}
	public String getType_keyword() {
		return type_keyword;
	}
	public void setType_keyword(String type_keyword) {
		this.type_keyword = type_keyword;
	}
	public String getType_info() {
		return type_info;
	}
	public void setType_info(String type_info) {
		this.type_info = type_info;
	}
	public String getType_content() {
		return type_content;
	}
	public void setType_content(String type_content) {
		this.type_content = type_content;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public int getType_set() {
		return type_set;
	}
	public void setType_set(int type_set) {
		this.type_set = type_set;
	}
	public String getType_nid() {
		return type_nid;
	}
	public void setType_nid(String type_nid) {
		this.type_nid = type_nid;
	}
	public int getIs_hiden() {
		return is_hiden;
	}
	public void setIs_hiden(int is_hiden) {
		this.is_hiden = is_hiden;
	}
	public int getAdd_time() {
		return add_time;
	}
	public void setAdd_time(int add_time) {
		this.add_time = add_time;
	}
	public int getIs_sys() {
		return is_sys;
	}
	public void setIs_sys(int is_sys) {
		this.is_sys = is_sys;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
	
}
