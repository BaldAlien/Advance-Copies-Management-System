package com.qjj.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/9
 */
public enum ResultMsgType {
    SUCCESS("成功"),
    QUERY_FAIL("查询失败"),
    PARAM_FAIL("参数缺失"),
    SAVE_FAIL("保存失败"),
    UPDATE_FAIL("更新失败"),
    REPEAT("数据已存在"),
    DELETE_FAIL("删除失败"),
    NIKE_NAME_NOT_NULL("昵称不能为空"),
    NAME_NOT_NULL("姓名不能为空"),
    PHOTO_NOT_NULL("头像不能为空"),
    PERMISSION_FAIL("暂无此权限"),
    NEED_APP_LOGIN("用户没有登录！请登录"),
    NEED_APP_ID("app用户Id参数异常, 参数名称: appId"),
    BIND_ERROR("参数校验异常"),
    SERVER_ERROR("服务端异常"),
    NEED_USER_LOGIN("登录账号数据错误！请重新登录"),
    VALIDATION_FAILED("验证失败"),
    ILLEGAL_ACCESS("访问非法");

    private final String value;

    public String getValue() {
        return this.value;
    }

    private ResultMsgType(final String value) {
        this.value = value;
    }
}
