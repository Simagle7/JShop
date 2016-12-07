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
        $("#tree").load('/rest/item/cat/catTree');
    });

});

//添加分组
var addGroup  =  function () {
    var $dimensionFrom = $("#dimensionform");
    $dimensionFrom.append("<div><input type='text'> " +
        "<i class='click-expand glyphicon glyphicon-plus group-param-add'></i>" +
        "<div><span>|-------</span> <input type='text'> " +
        "<i class='click-collapse glyphicon glyphicon-minus group-param-remove'></i> </div></div>")
};
//添加分组参数
$(document).off("click",".group-param-add");
$(document).on("click",".group-param-add", function () {
    var _dom = $(this);
    _dom.after("<div><span>|-------</span> <input type='text'> " +
        "<i class='click-collapse glyphicon glyphicon-minus group-param-remove'></i> </div>");
    // event.stopPropagation();
});

//移除分组参数
$(document).off("click", ".group-param-remove");
$(document).on("click", ".group-param-remove", function () {
     $(this).parent().remove();
});

//添加商品
var addItem = function () {
    if (validator.form()) {
        var cid = $("input[name=cid]").val();
        if (isNull(cid)) {
            swal({title: "请选择分类", text: "未选择任何分类！", type: "error"});
        }
        var img = [];
        $("#itemImg img").each(function (index, element) {
            var src = $(element).attr('src');
            img.push(src);
        });
        var image = img.join(",");
        console.log(image);
        var data = $("#addItem").serialize();
        var description = editor.$txt.html();
        data += "&description=" + description;
        data += "&image=" + image;
        console.log(data);
        $.ajax({
            url: 'saveItem',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (result) {
                if (isSuccess(result)) {
                    swal({title: "商品添加成功！", type: "success"}, function () {
                        $('#add').modal('hide');
                        //0.5秒延迟
                        setTimeout(function () {
                            window.location.href = "list";
                        },500);
                    });
                } else {
                    swal({title: result.msg, type: "error"});
                }
            }
        })
    }
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
