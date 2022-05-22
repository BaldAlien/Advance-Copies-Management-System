package com.qjj.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zjw
 * @package drug
 * @Date 2022/3/11
 * @Time 23:56
 */
@Slf4j
public class ResultUtil {

    private static final int SUCCESS = 200;
    private static final int ERROR = 500;
    private static final int VALID_ERROR = 400;
    /** 消息说明 */
    private String msg;
    /** 返回数据 */
    private Object data;
    /** 备用的数据字段 */
    private Object result;
    /** 返回状态 200:成功  500:失败 */
    private int status;

    private long count;

    public static ResultUtil resultSuccess(Object data, String message, Object result){
        return result(data, message, result, SUCCESS);
    }

    public static ResultUtil resultSuccess(Object data, String message){
        return resultSuccess(data, message, null);
    }

    public static ResultUtil resultSuccess(String message){
        return resultSuccess(null, message, null);
    }

    public static ResultUtil resultError(Object data, String message, Object result){
        return result(data, message, result, ERROR);
    }

    public static ResultUtil resultValidError(Object data, String message){
        return result(data, message,null, VALID_ERROR);
    }

    public static ResultUtil resultError(Object data, String message){
        return resultError(data, message, null);
    }

    public static ResultUtil resultError(String message){
        return resultError(null, message, null);
    }

    public static ResultUtil resultStatus(Object data, String message, int status){
        return result(data, message, null,status);
    }

    private static ResultUtil result(Object data, String msg, Object result, int status){
        ResultUtil ru = new ResultUtil();
        ru.setMsg(msg);
        ru.setData(data);
        ru.setResult(result);
        ru.setStatus(status);
        return ru;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
