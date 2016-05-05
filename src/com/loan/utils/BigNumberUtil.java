/**
 * Copyright (C)  版权所有
 * 文件名： BigNumberUtil.java
 * 包名： com.loan.utils
 * 说明：
 * @author admin
 * @date Apr 18, 2016 1:50:40 PM
 * @version V1.0
 */ 
package com.loan.utils;

import java.math.BigDecimal;

/**
 * 类名： BigNumberUtil
 * 描述：
 * @author admin
 * @date Apr 18, 2016 1:50:40 PM
 *
 *
 */
public class BigNumberUtil {
	
	/**
	 * 
	 * 方法描述： add2String
	 * @param num
	 * @param num1
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 2:14:12 PM
	 */
	public static String add2String(String num, String num1) {
		num = StringUtil.KillNull(num, "0.00");
		num1 = StringUtil.KillNull(num1, "0.00");
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		return bigDecimal.add(bigDecimal1).toString();
	}


	/**
	 * 
	 * 方法描述：加法 
	 * @param s
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 2:13:37 PM
	 */
	public static String Add(String... s) {
		String temp = "0.00";
		for (String str : s) {
			str = StringUtil.KillNull(str, "0.00");
			temp = add2String(temp, str);
		}
		return temp;
	}
	
	/**
	 * 
	 * 方法描述： 判断num1是否大于num2 1 num1 大于 num2  0 num1 等于num2 -1 num1小余num2
	 * @param num1
	 * @param num2
	 * @return
	 * int
	 * @author admin
	 * @date Apr 18, 2016 2:13:14 PM
	 */
	public static int isGreat(String num1,String num2){
		String temp = String.valueOf(Subtract(num1, num2));
		if(temp.startsWith("-")){
			return Integer.valueOf(-1);
		}else if ("0.00".equals(temp)||"0.0".equals(temp)||"0".equals(temp)) {
			return Integer.valueOf(0);
		}else{
			return Integer.valueOf(1);
		}
	          
	}
	/**
	 * 
	 * 方法描述： 减法
	 * @param num
	 * @param num1
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 2:12:03 PM
	 */
	public static String Subtract(String num, String num1) {
		num = StringUtil.KillNull(num, "0.00");
		num1 = StringUtil.KillNull(num1, "0.00");
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		return bigDecimal.subtract(bigDecimal1).toString();
	}
	
	
	/**
	 * 
	 * 方法描述：乘法 
	 * @param num
	 * @param num1
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 2:11:47 PM
	 */
	public static String Multiply(String num, String num1) {
		if ("".equals(num) || num == null) {
			num = "0.00";
		}
		if ("".equals(num1) || num1 == null) {
			num1 = "0.00";
		}
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		return bigDecimal.multiply(bigDecimal1).toString();
	}

	public static String Divide2(String num, String num1) {
		if ("".equals(num) || num == null) {
			num = "0.00";
		}
		if ("".equals(num1) || num1 == null) {
			num1 = "1.00";
		}
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		return bigDecimal.divide(bigDecimal1, 2, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 
	 * 方法描述： 
	 * @param num
	 * @param num1
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 2:09:32 PM
	 */
	public static String Divide5(String num, String num1) {
		if ("".equals(num) || num == null) {
			num = "0.00";
		}
		if ("".equals(num1) || num1 == null) {
			num1 = "1.00";
		}
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		return bigDecimal.divide(bigDecimal1, 5, BigDecimal.ROUND_HALF_UP)
				.toString();

	}


	/**
	 * 
	 * 方法描述： 除法运算
	 * @param num
	 * @param num1
	 * @param digits 
	 * @param type 取值方式 (1)：往上近似,例: 1.5 ->2 (2)往下近似,例: 1.5 ->1
	 * @return
	 * String
	 * @author admin
	 * @date Apr 18, 2016 1:58:56 PM
	 */
	public static String Divide(String num, String num1, int digits, String type) {
		String value = "0";
		if ("".equals(num) || num == null) {
			num = "0.00";
		}
		if ("".equals(num1) || num1 == null) {
			num1 = "1.00";
		}
		BigDecimal bigDecimal = new BigDecimal(num);
		BigDecimal bigDecimal1 = new BigDecimal(num1);
		if (StringUtil.equals("1", type)) {
			value = bigDecimal.divide(bigDecimal1, digits, BigDecimal.ROUND_HALF_UP).toString();
		} else if (StringUtil.equals("2", type)) {
			value = bigDecimal.divide(bigDecimal1, digits, BigDecimal.ROUND_HALF_DOWN).toString();
		} else {
			value = bigDecimal.divide(bigDecimal1, digits, BigDecimal.ROUND_DOWN).toString();
		}
		return value;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Subtract("122.3","2"));
	}

}