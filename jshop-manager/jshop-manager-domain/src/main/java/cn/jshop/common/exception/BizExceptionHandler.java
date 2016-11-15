package cn.jshop.common.exception;


import cn.jshop.common.sys.ResponseT;
import cn.jshop.common.sys.ResponseTs;
import cn.jshop.common.utils.RtnCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by 郭旭辉 on 2016/3/21.
 */
public class BizExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(BizExceptionHandler.class);
    public static final String errorMsgPattern = "invoke{} erro: {}";

//    @Override
    public ResponseT handleException(Exception exception, HttpServletRequest request) {
        boolean isDebug = false;
        if (request.getParameter("debug") != null) {
            isDebug = true;
        }
        ResponseT<String> responseT = null;
        //构造 BizException
        BizException bizException = null;
        if (exception instanceof BizException) { //业务预知的异常
            bizException = (BizException) exception;
            responseT = ResponseTs.<String>newResponseException(bizException, isDebug);
            logger.error(errorMsgPattern, request.getRequestURL(), ((BizException) exception).getMsg());
        } else {

            if (isDebug) {
                bizException = new BizException(RtnCodeEnum.UNKNOW.getValue(), RtnCodeEnum.UNKNOW.getDesc(), exception.getMessage());
            } else {
                bizException = new BizException(RtnCodeEnum.UNKNOW.getValue(), RtnCodeEnum.UNKNOW.getDesc());
            }
            responseT = ResponseTs.<String>newResponseException(bizException, isDebug);
            logger.error(errorMsgPattern, request.getRequestURL(), exception);
        }

        return responseT;
    }
}
