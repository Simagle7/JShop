package cn.jshop.common.utils;

/**
 * Created by 郭旭辉 on 2016/3/18.
 */
public enum RtnCodeEnum {
    SUCCESS("success", TBCConstants.SUCC_CODE, "请求成功"),

    UNKNOW("unknow", "1000001", "未知异常"),

    APP_OVER_INVOCATION_LIMIT("over_limit", "1000002", "请不要频繁调用接口，您的调用次数已超过了限制!"),

    PARAMETER_ERROR("parameter_error", "1000003", "请求参数错误"),

    NET_ERROR("net_error", "1000004", "网络异常，请稍后重试");

    private String code;

    private String value;

    private String desc;

    /**
     * Creates a new instance of RtnCodeEnum.
     *
     * @param value
     * @param desc
     */
    private RtnCodeEnum(String code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    /**
     *
     * 通过code去拿枚举值
     *
     * @author gfzhao
     * @param code
     * @return
     * @since v0.0.1
     */
    public static RtnCodeEnum codeOf(String code) {
        if(code == null ){
            return NET_ERROR;
        }
        for (RtnCodeEnum rtnCodeEnum : RtnCodeEnum.values()) {
            if (code.equals(rtnCodeEnum.getCode())) {
                return rtnCodeEnum;
            }
        }
        return NET_ERROR;
    }

    /**
     * 通过name去拿枚举值
     *
     * @author gfzhao
     * @param name
     * @return
     * @since v0.0.1
     */
    public static RtnCodeEnum nameOf(String name) {
        if(name == null ){
            return NET_ERROR;
        }
        for (RtnCodeEnum rtnCodeEnum : RtnCodeEnum.values()) {
            if (name.equals(rtnCodeEnum.name())) {
                return rtnCodeEnum;
            }
        }
        return NET_ERROR;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
