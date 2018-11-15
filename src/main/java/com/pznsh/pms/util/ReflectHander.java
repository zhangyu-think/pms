package com.pznsh.pms.util;

import java.lang.reflect.Field;

/**
 * 反射类，用于获取类的属性
 */
public class ReflectHander {
    // 获取成员变量
    public static Field[] getField(Object object){
        return object.getClass().getDeclaredFields();
    }
}