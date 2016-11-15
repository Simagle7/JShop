package cn.jshop.common.utils.User;

/**
 * Created by 郭旭辉 on 2016/3/22.
 */
public class UserContextHolder {
    private static ThreadLocal<IUserContext> userContextThreadLocal = new ThreadLocal<>();

    public static void setUserContext(IUserContext userContext){
        userContextThreadLocal.set(userContext);
    }

    public static IUserContext getUserContext(){
        return userContextThreadLocal.get();
    }
}
