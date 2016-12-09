/**
 * Created by simagle on 2016/10/20.
 */



$(document).ready(function () {
    $("#catBounced").popover({
        title: '选择分类',
        delay: 0.1,
        html: true,
        content: "<div id='tree'></div>",
        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content" ><p></p></div></div></div>',
    });
    $("#catBounced").on("shown.bs.popover", function () {
        $("#tree").load('item/cat/catTree',{allIn: false});
    });

});

//添加分组
var addGroup = function () {
    var $dimensionFrom = $("#dimensionform");
    $dimensionFrom.append("<div name='group'><input type='text'> " +
        "<i class='click-expand glyphicon glyphicon-plus group-param-add'></i>" +
        "<div name='param'><span>|-------</span> <input type='text'> " +
        "<i class='click-collapse glyphicon glyphicon-minus group-param-remove'></i> </div></div>")
};
//添加分组参数
$(document).off("click", ".group-param-add");
$(document).on("click", ".group-param-add", function () {
    var _dom = $(this);
    _dom.after("<div name='param'><span>|-------</span> <input type='text'> " +
        "<i class='click-collapse glyphicon glyphicon-minus group-param-remove'></i> </div>");
    // event.stopPropagation();
});

//移除分组参数
$(document).off("click", ".group-param-remove");
$(document).on("click", ".group-param-remove", function () {
    var _doms = $(this).parent().parent().find(".group-param-remove");
    if (_doms.length > 1) {
        $(this).parent().remove();
    } else {
        swal({title: "分组参数", text: "分组参数不能少于一个！", type: "warning"})
    }
});

//添加商品规格参数
var addItem = function () {
    //组装规格参数
    var params = [];
    var groups = $("#dimensionform").find("[name=group]");
    groups.each(function (i, e) {
        var p = $(e).find("[name=param]");
        var _ps = [];
        p.each(function (_i, _e) {
            var _val = $(_e).find("input").val();
            if ($.trim(_val).length > 0) {
                _ps.push(_val);
            }else{
                swal({title:"分组参数", text:"第"+i+"分组存在空参数",type:"warning"}, function () {
                    return ;
                });
            }
        });
        var _val = $(e).find("input").val();
        if ($.trim(_val).length > 0 && _ps.length > 0) {
            params.push({
                "group": _val,
                "params": _ps
            });
        }else{
            swal({title:"分组参数",text: "第"+i+"分组为空", type: "warning"}, function () {
                return ;
            });
        }
    });
    var cid = $("input[name=cid]").val();
    if (isNull(cid)) {
        swal({title: "请选择分类", text: "未选择任何分类！", type: "error"});
    }

    //状态参数
    var data = {cid:cid, param_data: JSON.stringify(params)};
    console.log(data.param_data);
    $.ajax({
        url: 'item/dimension/saveDimension',
        type: 'POST',
        dataType: 'JSON',
        data: data,
        success: function (result) {
            if (isSuccess(result)) {
                swal({title: "商品规格参数模板添加成功！", type: "success"}, function () {
                    $('#add').modal('hide');
                    //0.5秒延迟
                    setTimeout(function () {
                        window.location.href = "item/dimension/list";
                    }, 500);
                });
            } else {
                swal({title: result.msg, type: "error"});
            }
        }
    })
};
//点击页面任意地方关闭弹框
$(document).on('click', function (e) {
    $('[data-toggle="popover"],[data-original-title]').each(function () {
        //the 'is' for buttons that trigger popups
        //the 'has' for icons within a button that triggers a popup
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            (($(this).popover('hide').data('bs.popover') || {}).inState || {}).click = false;  // fix for BS 3.3.6
        }
    });
});
