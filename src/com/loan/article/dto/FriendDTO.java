package com.loan.article.dto;

import java.io.Serializable;

public class FriendDTO implements Serializable{

	private static final long serialVersionUID = 6729417215481727380L;
	
	public int id;
	public String link_txt;
	public String link_href;
	public String link_img;
	public int link_order;
	public int  link_type;
	public int  is_show;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink_txt() {
		return link_txt;
	}
	public void setLink_txt(String link_txt) {
		this.link_txt = link_txt;
	}
	public String getLink_href() {
		return link_href;
	}
	public void setLink_href(String link_href) {
		this.link_href = link_href;
	}
	public String getLink_img() {
		return link_img;
	}
	public void setLink_img(String link_img) {
		this.link_img = link_img;
	}
	public int getLink_order() {
		return link_order;
	}
	public void setLink_order(int link_order) {
		this.link_order = link_order;
	}
	public int getLink_type() {
		return link_type;
	}
	public void setLink_type(int link_type) {
		this.link_type = link_type;
	}
	public int getIs_show() {
		return is_show;
	}
	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}
	

}
