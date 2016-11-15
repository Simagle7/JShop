package cn.jshop.common.sys;


import cn.jshop.common.exception.BizException;
import cn.jshop.common.utils.RtnCodeEnum;

/**
 * Created by 郭旭辉 on 2016/3/21.
 *
 * response 工具类
 */
public class ResponseTs {
    /**
     * 返回未知异常
     * @return
     */
    public static <T> ResponseT newUnknow(){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.UNKNOW);
        return responseT;
    }

    /**
     *
     * 成功返回
     *
     * @return
     */
    public static <T> ResponseT newOK(){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.SUCCESS);
        return responseT;
    }

    /**
     *
     * @param ex
     * @param isDebug  是否调试模式    true 调试模式，返回详细的错误堆栈信息
     * @param <T>
     * @return
     */
    public static <T> ResponseT<T> newResponseException(BizException ex, boolean isDebug){
        ResponseT<T> responseT = new ResponseT<T>(ex, isDebug);
        return responseT;
    }

    /**
     *
     * 业务异常返回
     *
     * @return
     */
    public static <T> ResponseT<T> newResponseException(BizException ex){
        ResponseT<T> responseT = new ResponseT<T>(ex);
        return responseT;
    }

    /**
     * 正常业务对象的返回
     * @param bizData
     * @return
     */
    public static <T> ResponseT newResponse(T bizData){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.SUCCESS);
        responseT.setBizData(bizData);
        return responseT;
    }

    /**
     * 返回网络异常
     * @return
     */
    public static <T> ResponseT newNetError(){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.NET_ERROR);
        return responseT;
    }

    /**
     * 返回请求参数异常
     * @return
     */
    public static <T> ResponseT newParamError(){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.UNKNOW);
        return responseT;
    }

    /**
     * 返回调用次数超限异常
     * @return
     */
    public static <T> ResponseT newOverLimit(){
        ResponseT<T> responseT = new ResponseT(RtnCodeEnum.APP_OVER_INVOCATION_LIMIT);
        return responseT;
    }
}
