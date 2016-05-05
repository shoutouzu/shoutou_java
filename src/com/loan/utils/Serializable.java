/**
 * Copyright (C)  版权所有
 * 文件名： Serializable.java
 * 包名： com.loan.utils
 * 说明：
 * @author admin
 * @date Apr 13, 2016 3:16:34 PM
 * @version V1.0
 */ 
package com.loan.utils;
/**
 * 类名： Serializable
 * 描述：
 * @author admin
 * @date Apr 13, 2016 3:16:34 PM
 *
 *
 */
public interface Serializable {  
    byte[] serialize();  
    void unserialize(byte[] ss);  
}  