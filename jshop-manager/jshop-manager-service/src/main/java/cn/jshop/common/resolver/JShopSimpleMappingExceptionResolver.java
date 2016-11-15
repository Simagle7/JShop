package cn.jshop.common.resolver;

import cn.jshop.common.exception.BizExceptionHandler;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 郭旭辉 on 2016/3/21.
 * Spring MVC 异常统一处理器
 */
public class JShopSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            response.setHeader("Content-type", "text/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            String jsonString = JSONArray.toJSONString(new BizExceptionHandler().handleException(ex, request));
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e){
//            throw new BizException()
        }
        return new ModelAndView();
    }
}
