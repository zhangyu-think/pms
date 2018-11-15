package com.pznsh.pms.util;

/**
 * 字符串处理类
 */
public class StringHader {
    // 判断两个字符串的值是否相等，区分大小写
    public static boolean isValueEqual(String str1, String str2){
        if (str1 == null && str2 == null){
            return true;
        }else if (str1==null || str2==null){
            return false;
        }else if (str1.equals(str2)){
            return true;
        }else{
            return false;
        }
    }
}
