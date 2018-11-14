package com.pznsh.pms.util;

/**
 * 返回结果类
 * @param <T>
 */
public class Result<T> {
    //响应码，1为成功
    private int code;
    //响应信息，
    private String msg;
    //数据
    private T data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
