package cn.jshop.common.utils;

/**
 * Created by 郭旭辉 on 2016/3/16.
 *
 * 成功操作返回码
 */
public enum RETURNCODE {
    LOGIN_SUCCESS("0000000","登录成功"),
    SUCCESS_COMPLETE("0000001", "操作成功"),
    DELETE_COMPLETE("0000002", "删除成功"),
    ADD_COMPLETE("0000003", "新增成功"),
    UPDATE_COMPLETE("0000004", "修改成功"),
    SENDSMS_SUCCESS("0000005", "验证码发送成功"),
    REGISTER_SUCCESS("0000006", "注册成功"),
    SEARCH_EXISTS("0000007", "查询存在")
    ;

    /**
     * 操作码.
     */
    private final String code;

    /**
     * 返回信息内容.
     */
    private final String message;

    /**
     * 单例操作码
     *
     * @param code    操作码
     * @param message the message
     */
    private RETURNCODE(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取操作码
     *
     * @return 操作码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取信息内容
     *
     * @return 信息内容
     */
    public String getMessage() {
        return message;
    }
}
