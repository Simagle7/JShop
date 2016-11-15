<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <ul id="catTree" class="ztree"></ul>
</div>
<script>

function zTreeOnClick(event, treeId, treeNode) {
    if(!treeNode.isParent){ //叶子节点

        $("#catName").addClass("cat").text(treeNode.name);
        $("input[name=cid]").attr("value",treeNode.id);
        $('.popover').popover('hide');
//        alert(treeNode.tId + ", " + treeNode.name);

    }
}

var setting = {
    async: {
        enable: true,
        url: "cat/getChildCat",
        type: 'GET',
        dataType: 'JSON',
        dataFilter: function(treeId, parentNode, responseData){return responseData.bizData},
        autoParam: ["id=pId"]
    },
    callback: {
        onClick: zTreeOnClick
    }
};

var zNodes = [];
$.ajax({
    url: 'cat/getChildCat',
    dataType: 'JSON',
    type: 'GET',
    data: {pId: 0},
    success: function (result) {
        zNodes = result.bizData;
        var zTreeObj = $.fn.zTree.init($("#catTree"), setting, zNodes);
    }
});


</script>

