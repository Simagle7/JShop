<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
         style="width: 670px;">
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
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>标题：</span></th>
                            <td width="35%"><input type="text" name="title"></td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>创建时间：</span></th>
                            <td width="35%">2016-10-25</td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>条形码：</span></th>
                            <td width="35%"><input type="text" name="barcode"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;类别：</span></th>
                            <td width="35%">
                                <button rel="popover" id="catBounced" type="button" class="btn btn-info">加载类别</button>
                                <span id="catName"></span>
                                <input type="text" name="cid" hidden>
                            </td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;价格：</span></th>
                            <td width="35%"><input type="text" name="priceView"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;库存：</span></th>
                            <td width="35%"><input type="text" name="num"></td>
                        </tr>
                        <tr>
                            <th><span class="pull-right">图片：</span></th>
                            <td colspan="3" id="itemImg" style="height: 111px">
                                <%--<button rel="popover" id="addImages" type="button" class="btn btn-info">添加图片</button>--%>
                                <%--<button type="button" id="addImages" class="btn btn-info dim"><i class="fa fa-upload"></i></button>--%>
                                <button type="button" id="addImages" class="pull-right btn btn-info"><i class="fa fa-upload"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right"><b>*</b>&nbsp;商品卖点：</span>
                            </th>
                            <td colspan="3"><textarea name="sell_point" style="width: 484px; height: 80px;"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right"><b>*</b>&nbsp;商品描述：</span>
                            </th>
                            <td colspan="3"><textarea id="textarea1" style="width: 484px; height: 80px;">
                                <p>请输入描述...</p>
                            </textarea>
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
<script type="text/javascript" src="/js/module/item/add.js"></script>