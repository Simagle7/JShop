<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<base href="http://eshop.cn/rest/" >
<style>
    .cat {
        font-size: 14px;
        margin-left: 4px;
        border: 1px solid #f5f5f5;
        background-color: #EFB45F;
        padding: 9px;
        color: white;
        border-radius: 5px;
    }
    label{
        margin: 0;
    }
</style>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight"
         style="width: 670px; height: 400px;">
        <div class="modal-header" style="padding: 10px 15px">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="false">×</span><span class="sr-only">关闭</span>
            </button>
            <span class="pull-left" style="font-size: 14px"> <b>添加商品 </b>(注：带 * 号为必填项)</span>
        </div>
        <small class="font-bold">
            <div class="modal-body" style="padding: 0">
                <form class="detail" id="addItem">
                    <table class="table table-bordered"
                           style="margin-bottom: 0;">
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>商品类别：</span></th>
                            <td width="35%">
                                <button rel="popover" id="catBounced" type="button" class="btn btn-info">加载类别</button>
                                <span id="catName"></span>
                                <input type="text" name="cid" hidden>
                            </td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>创建时间：</span></th>
                            <td width="35%">
                                <c:set var = "createDate" value="<%= new Date() %>"/>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${createDate}" type="date"/>
                            </td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>规格参数：</span></th>
                            <td colspan="3">
                                <div class="group-box-btn">
                                    <button class="btn btn-info" type="button"  onclick="addGroup()" >添加分组</button>
                                </div>
                                <div id="dimensionform" class="group-box">
                                    <div name="group">
                                        <input type="text">
                                        <i class="click-expand glyphicon glyphicon-plus group-param-add"></i>
                                        <div name="param">
                                            <span>|-------</span>
                                            <input type="text">
                                            <i class="click-collapse glyphicon glyphicon-minus group-param-remove"></i>
                                        </div>
                                    </div>

                                </div>
                            </td>
                        </tr>

                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="button" onclick="addItem()">保存
                        </button>
                        <button type="button" class="btn btn-white"
                                data-dismiss="modal">关闭
                        </button>
                    </div>
                </form>
            </div>

        </small>
    </div>
    <small class="font-bold">
    </small>
</div>
<small class="font-bold">
</small>
<script type="text/javascript" src="/js/module/dimension/add.js"></script>