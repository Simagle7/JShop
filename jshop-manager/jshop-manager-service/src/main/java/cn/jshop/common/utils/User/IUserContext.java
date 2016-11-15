package cn.jshop.common.utils.User;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/3/22.
 * 获取业务上下文接口，需要业务方实现
 */
public interface IUserContext {
    public static  final String UID = "uid";

    public Map<String, Object> getContext();
}
