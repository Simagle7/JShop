/**
 * Created by simagle on 2016/10/24.
 */
/**qtip最顶部**/
$.fn.qtip.zindex = 99999999;

/**错误显示**/
function errorPlacement(error, element) {
    if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
        var eid = element.attr('name'); //获取元素的name属性
        element = $("input[name='" + eid + "']").last().parent(); //将错误信息添加当前元素的父结点后面
    }
    if (!error.is(':empty')) {
        $(element).not('.valid').qtip({
            overwrite: false,
            content: error,
            hide: false,
            show: {
                event: false,
                ready: true
            },
            style: {
                classes: 'qtip-cream qtip-shadow qtip-rounded'
            },
            position: {
                my: 'top left',
                at: 'bottom right'
            }
        }).qtip('option', 'content.text', error);
    }
    else {
        element.qtip('destroy');
    }
}

/**通用方法**/
//请求响应是否成功
function isSuccess(result) {
    var rtnCode = result.rtnCode.substring(0, 2);
    return rtnCode == '00';
}
//判断值是否为空
function isNull(value){
    if(value == null || typeof(value) === "undefined" || value==''){
        return true;
    }
    return false;
}