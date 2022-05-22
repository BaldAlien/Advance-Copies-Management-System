package com.qjj.utils;

/**
 * <p>
 *
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/9
 */


import com.qjj.enums.ResultMsgType;
import com.qjj.enums.ResultStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
        value = "ResultBean",
        description = "接口返回对象"
)
public final class ResultBean<T> {
    @ApiModelProperty("返回状态码。200代表成功, 其他失败")
    private int status;
    @ApiModelProperty("返回的信息")
    private String msg;
    @ApiModelProperty("返回的总条数")
    private long count;
    @ApiModelProperty("接口返回的数据对象")
    private T data;

    private ResultBean(T data) {
        this(ResultStatusType.SUCCESS.getValue(), ResultMsgType.SUCCESS.getValue(), data);
    }

    private ResultBean(int status, String msg, T data) {
        this.status = ResultStatusType.SUCCESS.getValue();
        this.msg = ResultMsgType.SUCCESS.getValue();
        this.count = 0L;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResultBean(int status, String msg, T data, long count) {
        this.status = ResultStatusType.SUCCESS.getValue();
        this.msg = ResultMsgType.SUCCESS.getValue();
        this.count = 0L;
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean(data);
    }

    public static <T> ResultBean<T> success(T data, int code) {
        return new ResultBean(code, (String)null, data);
    }

    public static <T> ResultBean<T> success(T data, ResultStatusType resultStatus) {
        return new ResultBean(resultStatus.getValue(), (String)null, data);
    }

    public static <T> ResultBean<T> success() {
        return new ResultBean(ResultStatusType.SUCCESS.getValue(), ResultMsgType.SUCCESS.getValue(), (Object)null);
    }

    public static <T> ResultBean<T> success(long count, T data) {
        return new ResultBean(ResultStatusType.SUCCESS.getValue(), ResultMsgType.SUCCESS.getValue(), data, count);
    }

    public static <T> ResultBean<T> success(T data, String msg) {
        return new ResultBean(ResultStatusType.SUCCESS.getValue(), msg, data);
    }

    public static <T> ResultBean<T> error(String message) {
        return new ResultBean(ResultStatusType.FAIL.getValue(), message, (Object)null);
    }

    public static <T> ResultBean<T> error(String msg, Integer code) {
        return new ResultBean(code, msg, (Object)null);
    }

    public int getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getCount() {
        return this.count;
    }

    public T getData() {
        return this.data;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setCount(final long count) {
        this.count = count;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public String toString() {
        return "ResultBean(status=" + this.getStatus() + ", msg=" + this.getMsg() + ", count=" + this.getCount() + ", data=" + this.getData() + ")";
    }

    private ResultBean() {
        this.status = ResultStatusType.SUCCESS.getValue();
        this.msg = ResultMsgType.SUCCESS.getValue();
        this.count = 0L;
    }
}
