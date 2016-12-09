/**
 * Created by simagle on 2016/10/20.
 */

$(document).ready(function () {
    $("#catBounced").popover({
        title: '选择分类',
        delay: 0.1,
        html: true,
        content: "<div id='tree'></div>",
        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
    });
    $("#catBounced").on("shown.bs.popover", function () {
        $("#tree").load('cat/catTree');
    });
});



//添加商品规格参数模板
var updateItem = function () {
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
        var data = $("#updateItem").serialize();
        var description = editor.$txt.html();
        data += "&description=" + description;
        data += "&image=" + image;
        console.log(data);
        $.ajax({
            url: 'updateItem',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (result) {
                if (isSuccess(result)) {
                    swal({title: "商品更新成功！", type: "success"}, function () {
                        $('#update').modal('hide');
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
