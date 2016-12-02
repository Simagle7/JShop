<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/24
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="filelist"></div>

<div id="container">

    <label>附件类型:</label> <select name="fileType" id="fileType" >
    <option value="1">-------请选择-----</option>
    <option value="商户营业执照">商户营业执照</option>
    <option value="税务登记证明">税务登记证明</option>
    <option value="商户信息变更表">商户信息变更表</option>
    <option value="其他">其他</option>
</select>
    <button class="button" id="pickfiles">选择文件</button>&nbsp;&nbsp;
    <button class="button" id="uploadfiles">批量上传</button>&nbsp;&nbsp;
    <button class="button"  onclick="window.location.reload()">刷新</button>&nbsp;&nbsp;
    <button class="button" onclick="window.close()">关闭窗口</button>
    <table style="width: 600px" id="uploadTable" border="1">
        <tr>
            <td>文件类型</td>
            <td>文件名称</td>
            <td>操作</td>
            <td>上传进度</td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript" src="/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="/lib/plupload/plupload.full.min.js"></script>

<script>

    //实例化一个plupload上传对象
    var uploader = new plupload.Uploader({
        browse_button : 'pickfiles', //触发文件选择对话框的按钮，为那个元素id
        runtimes : 'html5,flash,silverlight,html4',
        url : '/rest/upload/img', //服务器端的上传页面地址
        flash_swf_url : 'lib/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : 'lib/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        chunk_size:"1m",
        multi_selection:true,
//        unique_names:true,
        filters : {
            max_file_size : '5mb',
            mime_types : [ {
                title : "图片类型",
                extensions : "jpg,jpeg,gif,png"
            } ]
        },
        init : {
            PostInit : function() {
                document.getElementById('uploadfiles').onclick = function() {
                    uploader.start();
                    return false;
                };
            },
            BeforeUpload:function(up,file){

//重点在这里，上传的时候自定义参数信息
//                uploader.setOption("multipart_params",{"apptype":1,"id":1,"fileType":map[file.id]});
            },
            FileUploaded:function(up,file){
                $("#"+file.id+"btn").parent().html("上传完毕");
                $("#"+file.id+"btn").remove();
            },
            FilesAdded : function(up, files) {
//                if($("#fileType").val()==1){
//                    alert("请选择附件类型！");
//
////清空刚才选择的文件
//                    plupload.each(files,function(file) {
//                        uploader.removeFile(file.id);
//                    });
//                    return false;
//                }
                plupload.each(files,function(file) {
//                    map[file.id]=$("#fileType").val();
//                    $("#uploadTable").append("<tr id='"+file.id+"tr'><td>"+$("#fileType").val()+"</td><td>"+file.name+"</td><td><button type='button' id='"+file.id+"btn' onclick=del('"+file.id+"')>删除</button> </td><td id='"+file.id+"_progress'></td></tr>");
                });
            },
            UploadProgress : function(up, file) {
                $("#"+file.id+"_progress").html('<span>'+ file.percent + "%</span>");
            },
            Error : function(up, err) {
                alert("此文件上传失败！");
            }
        }
    });
    uploader.init();

    //根据文件id删除此文件，并且在table中删除此文件的信息
    function del(id){
        uploader.removeFile(id);
        $("#"+id+"tr").remove();
        map[id]="";
    }

</script>
</html>
