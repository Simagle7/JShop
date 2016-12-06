/**
 * Created by simagle on 2016/10/20.
 */

var uploader = new plupload.Uploader({
    runtimes: 'html5,flash,silverlight,html4',
    browse_button: 'addImages', // 上传选择的点选按钮，**必需**
    container: "itemImg",
    url: '/rest/upload/img',
    max_file_size: '5mb', // 最大文件体积限制
    flash_swf_url: 'lib/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
    silverlight_xap_url: 'lib/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
    // max_retries: 3, // 上传失败最大重试次数
    // dragdrop: false, // 开启可拖曳上传
    // drop_element: null, // 拖曳上传区域元素的 ID，拖曳文件或文件夹后可触发上传
    // chunk_size: '2mb', // 分块上传时，每块的体积
    auto_start: true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
    filters: [{
        title: "Image files",
        extensions: "jpg,jpeg,png,gif"
    }],
    init: {
        'FilesAdded': function (up, files) {
            plupload.each(files, function (file) {
                // 文件添加进队列后,处理相关的事情
                uploader.start();
            });
        },
        'BeforeUpload': function (up, file) {
            //todo 打开加载层
        },
        'UploadProgress': function (up, file) {
            // 每个文件上传时,处理相关的事情
            //console.log(file.percent)
        },
        'FileUploaded': function (up, file, info) {
            // todo 关闭弹窗
            var imgPath = JSON.parse(info.response).bizData;
            console.log(info);
            var $imgDom = $("#addImages");
            var id = new Date().getTime();
            $imgDom.before("<div class='pull-left img-box' rel='popover' id='" + id + "' ><div class='img-content'><img src='" + imgPath + "' alt='上传失败'/></div><div class='img-close-btn'><i class='fa fa-times-circle-o'></i></div></div>");

        },
        'Error': function (up, err, errTip) {
            //上传出错时,处理相关的事情

            layer.alert("上传失败", {icon: 2});
        },
        'UploadComplete': function () {
            //队列文件处理完毕后,处理相关的事情
        }
    }
});

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

});
//表单检验规则
var validator = $("#updateItem").validate({
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

uploader.init();


//预览图片
// $(document).on("click", ".img-content", function () {
//     // var $imgDom = $($(this).children(this).get(0));
//     var $imgDom = $(this).parent();
//     console.log($imgDom);
//     var id = "#" + $imgDom.attr("id");
//     var imgPath = $imgDom.find("img").attr("src");
//     console.log(id, imgPath);
//     $(id).popover({
//         html: true,
//         content: "<img src='" + imgPath + "' alt='预览失败' class='preview-img'/>",
//         template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content" style="padding: 0"><p></p></div></div></div>'
//     });
// });
$(document).on("click", ".img-box", function () {
    // var $imgDom = $($(this).children(this).get(0));
    var $imgDom = $(this);
    console.log($imgDom);
    var id = "#" + $imgDom.attr("id");
    var imgPath = $imgDom.find("img").attr("src");
    console.log(id, imgPath);
    $(id).popover({
        html: true,
        content: "<img src='" + imgPath + "' alt='预览失败' class='preview-img'/>",
        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content" style="padding: 0"><p></p></div></div></div>'
    });
});

//移除图片
$(document).on("click", ".img-close-btn", function (event) {
    $(this).parent().remove();//移除当前点击元素的父元素
    event.stopPropagation();
});

//添加商品
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
