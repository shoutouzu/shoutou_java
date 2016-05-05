/**
 * Copyright (C)  版权所有
 * 文件名： GlobalUtils.java
 * 包名： com.loan.utils
 * 说明：
 * @author admin
 * @date Apr 8, 2016 2:48:05 PM
 * @version V1.0
 */ 
package com.loan.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 类名： GlobalUtils
 * 描述：
 * @author admin
 * @date Apr 8, 2016 2:48:05 PM
 *
 *
 */
public class GlobalUtils {
	
	public static String getRepayType(int type)
    {
		switch (type) {
		case 1:
			return "按天到期还款";
		case 2:
			return "按月分期还款";
		case 4:
			return "每月还息到期还本";
		case 5:
			return "一次性还款";
		default:
			break;
		}
        return "";
    }
	public static LinkedHashMap<String,String> getStockTypeMap(){
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("", "不限制");
		map.put("1", "新手专享");
		map.put("2", "月月盈");
		map.put("3", "打新宝");
		return map;
	}
	public static LinkedHashMap<String,String> getBorrowStatusMap(){
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("", "不限制");
		map.put("2", "进行中");
		map.put("4", "复审中");
		map.put("6", "还款中");
		map.put("7", "已完成");
		return map;
	}
	public static LinkedHashMap<String,String> getBorrowDurationMap(){
		LinkedHashMap <String,String> map = new LinkedHashMap<String,String>();
		map.put("", "不限制");
		map.put("0-3", "3个月以内");
		map.put("3-6", "3-6个月");
		map.put("6-12", "6-12个月");
		map.put("12-24", "12-24个月");
		return map;
	}
	public static void main(String[] args) {
		Map<String, String> map = getBorrowDurationMap();
		for(Map.Entry<String, String> ss:map.entrySet()){
			System.out.println("key:"+ss.getKey());
			System.out.println("val:"+ss.getValue());
		}
		for(String s:map.keySet()){
			String aString = map.get(s);
			System.out.println("key :"+s + " val :"+aString);
		}
	}
}
