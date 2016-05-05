package com.loan.article.dto;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;


public class ArticleDTO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 356259050805548841L;
	public int id;
	public String title;
	public String art_set;
	public String art_time;
	public String art_url;
	public String art_img;
	public String art_info;
	public String art_keyword;
	public int type_id;
	public int sort_order;
	public int read_count;
	public String art_content;
	public int  getNid(String flag){
		int nid=0;
		if("gonggao".equals(flag)){
			nid = 43;
		}else if("news".equals(flag)){
			nid = 2;
		}else if("gnews".equals(flag)){
			nid = 38;
		}else if("meitibaodao".equals(flag)){
			nid = 46;
		}
		return nid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArt_set() {
		return art_set;
	}
	public void setArt_set(String art_set) {
		this.art_set = art_set;
	}
	public String  getArt_time() {
		return art_time;
	}
	public void setArt_time(String art_time) {
		this.art_time = art_time;
	}
	public String getArt_url() {
		return art_url;
	}
	public void setArt_url(String art_url) {
		this.art_url = art_url;
	}
	public String getArt_img() {
		return art_img;
	}
	public void setArt_img(String art_img) {
		this.art_img = art_img;
	}
	public String getArt_info() {
		return art_info;
	}
	public void setArt_info(String art_info) {
		this.art_info = art_info;
	}
	public String getArt_keyword() {
		return art_keyword;
	}
	public void setArt_keyword(String art_keyword) {
		this.art_keyword = art_keyword;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getArt_content() {
		return art_content;
	}
	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}
	
}
