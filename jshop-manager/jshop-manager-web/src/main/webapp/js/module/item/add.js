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
        $("#tree").load('catTree');
    });
    $("#addImages").popover({
        title: '添加图片',
        delay: 0.1,
        html: true,
        content: "<div id='images'></div>",
        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
    });
    $("#addImages").on("shown.bs.popover", function () {
        $("#images").load('addImages');
    });

});
var validator = $("#addItem").validate({
    rules: {
        title: {required: true},
        cid: {required: true, min: 1},
        priceView: {min: 0},
        num: {min: 1},
        sell_point: {required: true},
        description: {required: true}

    },
    messages: {
        title: {required: "标题不能为空"},
        cid: {required: "未选择分类", min: "未选择分类"},
        priceView: {min: "价格不能为负数"},
        num: {min: "库存不能为负数"},
        sell_point: {required: "卖点不能为空"},
        description: {required: "描述不能为空"}
    },
    errorPlacement: errorPlacement,
    success: "valid"
});
//加入富文本编辑器
var editor = new wangEditor('textarea1');
editor.config.menus = [
    'bold', 'underline', 'italic', 'strikethrough', 'eraser', 'forecolor', 'bgcolor', '|', 'link', 'unlink', 'emotion', '|', 'img', '|', 'undo', 'redo', '|', 'quote', 'fontfamily', 'fontsize', 'head', 'unorderlist', 'orderlist', 'alignleft', 'aligncenter', 'alignright'
];
editor.create();

var addItem = function () {
    if (validator.form()) {
        var cid = $("input[name=cid]").val();
        if (isNull(cid)) {
            swal({title: "请选择分类", text: "未选择任何分类！", type: "error"});
        }
        var data = $("#addItem").serialize();
        var description = editor.$txt.html();
        data += "&description="+description;
        console.log(data);
        $.ajax({
            url: 'saveItem',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"商品添加成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#add').modal('hide');
                    });
                }else{
                    swal({title:result.msg,type:"error"});
                }
            }
        })
    }
};

$(document).on('click', function (e) {
    $('[data-toggle="popover"],[data-original-title]').each(function () {
        //the 'is' for buttons that trigger popups
        //the 'has' for icons within a button that triggers a popup
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            (($(this).popover('hide').data('bs.popover') || {}).inState || {}).click = false;  // fix for BS 3.3.6
        }
    });
});