package cn.jshop.common.utils.http;


//import cn.gdpu.his.domain.user.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 郭旭辉 on 2016/3/21.
 *
 * http协议处理类
 */
public class HttpUtils {
    public static final String ACCESS_TOKEN = "access_token";

    /**
     * 根据cookie名称获取指定的cookie
     * @param cookies
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(Cookie[] cookies, String cookieName){
        Cookie result = null;
        for (Cookie cookie : cookies){
            if (cookieName.equalsIgnoreCase(cookie.getName())){
                result = cookie;
            }else {
                continue;
            }
        }
        return result;
    }

    /**
     * 设置cookie
     * @param response
     * @param token     token签名
     * @param timeout   过期时间,默认30分钟过期
     */
    public static void setCookie(HttpServletResponse response, String token, int timeout){
        Cookie cookie = new Cookie(ACCESS_TOKEN,token);
        cookie.setMaxAge(timeout);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 设置session,并设置过滤时间
     * @param session   session
     * @param user  用户实体
     * @param timeout   设置过期时间，默认为30分钟
     */
//    public static void generalUserSession(HttpSession session, User user, String token, int timeout){
//        session.setAttribute(token, user);
//        session.setMaxInactiveInterval(timeout);
//    }


}
