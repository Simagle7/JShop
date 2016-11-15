package cn.jshop.common.filter;


import cn.jshop.common.exception.BizException;
import cn.jshop.common.exception.BizExceptionHandler;
import cn.jshop.common.utils.ERRORCODE;
import cn.jshop.common.utils.PropertiesUtil;
import cn.jshop.common.utils.http.HttpUtils;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 郭旭辉 on 2016/3/16.
 */
public class JShopSessionFilter extends OncePerRequestFilter {

    private static final String[] ignoreUrlPattern = new PropertiesUtil().getProp4Config("/ignoreUrl-config.properties").getProperty("IGNOREURL").split(",");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //请求的uri
        String uri = request.getRequestURI();
        //是否过滤
        boolean doFilter = true;
        for (String s : ignoreUrlPattern) {
            if (uri.indexOf(s) != -1) {
                doFilter = false;
                break;
            }
        }

        //执行过滤，从session中获取登录者实体
        if (doFilter) {
            Cookie[] cookies = request.getCookies();
            BizException bizException = null;
            if (cookies == null || cookies.length == 0){//客户端并没有存access_token
                //如果不存在cookie数组，统一抛出登录异常
                bizException = new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
                getExceptionJson(request, response, bizException);
                return;
            }
            Cookie cookie = HttpUtils.getCookie(cookies, "access_token");
            if (cookie == null){
                //客户端并没有存access_token
                bizException =  new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
                getExceptionJson(request, response, bizException);
                return;
            }
            Object obj = request.getSession().getAttribute(cookie.getValue());
            if (null == obj) {
                //如果不存在session对象，统一抛出登录异常
                bizException =  new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
                getExceptionJson(request, response, bizException);
                return;
            }else {
                //如果session中存在登录实体，则继续登录
                filterChain.doFilter(request, response);
            }
        } else {
            //如果不执行过滤，则继续
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 判断是否为Ajax请求
     * @param request
     * @return 返回，true，false
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header)) {
            return true;
        } else {
            return false;
        }
    }

    private void getExceptionJson(HttpServletRequest request, HttpServletResponse response, Exception ex){
        try {
            response.setHeader("Content-type", "text/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            String jsonString = JSONArray.toJSONString(new BizExceptionHandler().handleException(ex, request));
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e){

        }
    }
}
