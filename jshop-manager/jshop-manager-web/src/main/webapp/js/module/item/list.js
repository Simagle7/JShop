/**
 * Created by simagle on 2016/10/17.
 */
function loadUpdateBounced(id) {
    $("#update").load('item/update',{id: id});
};

function loadAddBounced() {
    $("#add").load('item/add');
}
function loadDimensionBounced(itemId, cid) {
    console.
    //先判断是否存在对应分类的参数模板
    $.ajax({
        url: "item/dimension/isExist",
        dataType:"json",
        type: 'GET',
        data:{cid:cid},
        success: function (result) {
            if(isSuccess(result)){
                //加载弹框
                $("#dimensionForm").load('item/loadDimension',{itemId: itemId});
            }
        }
    })

}
function disabledOrEnabled(id, status) {
   var text = status == 1 ? "停售" : "启用";
   swal({
       title: "确定要" + text + "该商品？",
       type: "warning",
       showCancelButton: true,
       confirmButtonColor: "#DD6B55",
       confirmButtonText: text,
       cancelButtonText: "取消"
   }, function () {
       $.ajax({
           url: 'item/disabledOrEnable',
           data: {id: id, status: status},
           type: "GET",
           async: false,
           success: function (result) {
               //重新加载页面
               if (isSuccess(result)) {
                   setTimeout(function () {
                       window.location.href = "item/list";
                   }, 500);
               }

           }
       });
   });
}
function deleteOne(id) {
   swal({
       title: "确定删除该条商品信息？",
       text: "删除后将无法恢复，请谨慎操作！",
       type: "error",
       showCancelButton: true,
       confirmButtonColor: "#DD6B55",
       confirmButtonText: "删除",
       cancelButtonText: "取消"
   }, function () {
       $.ajax({
           url: 'item/deleteOne',
           data: {id: id},
           type: "GET",
           async: false,
           success: function (result) {
               //重新加载页面
               if (isSuccess(result)) {
                   setTimeout(function () {
                       window.location.href = "item/list";
                   }, 500);
               }

           }
       });
   });
}

//添加商品规格参数
var addDimensionRel = function (id) {

};
var pageNo = 1;         //页码
var pageSize = 10;      //页大小
var searchForm = "";    //查询条件

/**
 * 选择页码
 */
$("#pageSize").change(function () {
    pageSize = $(this).children('option:selected').val();
    window.location.href = "item/list?pageNo=" + pageNo + "&pageSize=" + pageSize;
});

/**
 * 分页查询
 */
var queryPage = function () {
    searchForm = $("#searchForm").serialize();
    searchForm += "&pageNo=" + pageNo;
    searchForm += "&pageSize=" + pageSize;
    window.location.href = "item/list?" + searchForm;
};

/**
 * 重置
 */
var clear = function () {
    //重置
    $("#searchForm")[0].reset();
    pageNo = 1;
    pageSize = 10;
    searchForm = "";
    queryPage();
};


//首页，上下页，尾页
var selectPage= function (value,total) {
    pageNo += parseInt(value);
    if (pageNo < 1) {
        pageNo = 1;
    }
    if (pageNo > total) {
        pageNo = total;
    }
    queryPage();
};