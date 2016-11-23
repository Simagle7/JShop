<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/17
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>医疗人员管理页面</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet"/>
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet"/>
    <link href="/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="/css/animate.min.css" rel="stylesheet"/>
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/plugins/sweetalert/sweetalert.css"/>

    <!-- 其他样式库 -->
    <link rel="stylesheet" href="/lib/zTree/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet" href="/lib/qtip/jquery.qtip.min.css"/>
    <link rel="stylesheet" href="/js/plugins/wangEditor/css/wangEditor.min.css"/>
    <style>
        .search-label {
            padding-right: 5px;
        }

        .btn-width {
            min-width: 60px;
        }

       .detail table th {
            font-size: 14px;
            background-color: #1ab394;
            color: #ffffff;
        }

        .detail table td {
            background-color: #f3f3f4;
        }

       .detail table td input[type='text'] {
            width: 150px;
        }
        .status{
            color: #fff;
            border: 1px solid;
            padding: 9px;
            font-size: 13px;
            border-radius: 5px;
        }
        .status-info{
            background-color: #23C6C8;
        }
        .status-warning{
            background-color: #F8AC59;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>商品信息信息管理</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">

                <div class="col-sm-12">
                    <div class="example-wrap">
                        <div class="example">
                            <div>
                                <form action="">
                                    <span><b>名称：</b></span>
                                    <label class="search-label"><input class="form-control input-outline" type="text"
                                                                       name="name"></label>
                                    <span><b>编号：</b></span>
                                    <label class="search-label"><input class="form-control input-outline" type="text"
                                                                       name="jobNumber"></label>
                                    <button type="button" class="btn btn-w-m btn-primary btn-width">查询</button>
                                    <button type="button" class="btn btn-w-m btn-primary btn-width">重置</button>
                                </form>
                            </div>
                            <div class="bootstrap-table">
                                <div class="fixed-table-toolbar">
                                    <div class="bars pull-left">
                                        <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                            <button data-toggle="modal" data-target="#add" type="button"
                                                    class="btn btn-outline btn-default" onclick="loadAddBounced()">
                                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                            </button>
                                            <div class="modal fade" id="add" tabindex="-1" role="dialog"
                                                 aria-hidden="true" style="display: none;">
                                            </div>
                                            <button id="deleteAll" type="button" class="btn btn-outline btn-default">
                                                <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <table class="table table-bordered" style="margin-bottom: 0">
                            <thead>
                            <tr>
                                <th width="2%"><input type="checkbox"></th>
                                <th width="8%">姓名</th>
                                <th width="10%">账号</th>
                                <th width="7%">工号</th>
                                <th width="10%">职务</th>
                                <th width="20%">主治</th>
                                <th width="15%">医生代码</th>
                                <th width="8%">状态</th>
                                <th width="20%">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--<c:forEach items="${data.rows}" var="el">--%>
                                <%--<tr>--%>
                                    <%--<td><input type="checkbox" name="id" value="<c:out value='${el.id}'/>"></td>--%>
                                    <%--<td><c:out value="${el.name}" /></td>--%>
                                    <%--<td><c:out value="${el.username}" /></td>--%>
                                    <%--<td><c:out value="${el.jobNumber}" /></td>--%>
                                    <%--<td><c:out value="${el.position}" /></td>--%>
                                    <%--<td><c:out value="${el.major}" /></td>--%>
                                    <%--<td><c:out value="${el.code}" /></td>--%>
                                    <%--<td>--%>
                                        <%--<c:if test="${el.status == 0}">--%>
                                            <%--<span class="status status-info"><i class="fa fa-check"></i>正常</span>--%>
                                        <%--</c:if>--%>
                                        <%--<c:if test="${el.status == 1}">--%>
                                            <%--<span class="status status-warning"><i class="fa fa-times"></i>停职</span>--%>
                                        <%--</c:if>--%>
                                    <%--</td>--%>
                                    <%--<td>--%>
                                        <%--<button data-toggle="modal" data-target="#update" type="button" class="btn btn-info" onclick="loadData(<c:out value="${el.id}"/>)">修改</button>--%>
                                            <%--&lt;%&ndash;<a href="queryOne?id=<c:out value="${el.id}"/>" style="color: #ffffff">修改</a></button>&ndash;%&gt;--%>
                                        <%--<div class="modal inmodal in" id="update" tabindex="-1" role="dialog"--%>
                                             <%--aria-hidden="true" style="display: none;">--%>

                                        <%--</div>--%>
                                        <%--<c:choose>--%>
                                            <%--<c:when test="${el.status == 1}">--%>
                                                <%--<button type="button" class="btn  btn-info" onclick="disabledOrEnabled(${el.id},0)">--%>
                                                    <%--启用--%>
                                                <%--</button>--%>
                                                <%--<button type="button" class="btn  btn-danger" onclick="deleteOne(${el.id})">--%>
                                                    <%--删除--%>
                                                <%--</button>--%>
                                            <%--</c:when>--%>
                                            <%--<c:when test="${el.status == 0}">--%>
                                                <%--<button type="button" class="btn  btn-warning" onclick="disabledOrEnabled(${el.id},1)">--%>
                                                    <%--停职--%>
                                                <%--</button>--%>
                                            <%--</c:when>--%>
                                        <%--</c:choose>--%>

                                    <%--</td>--%>
                                <%--</tr>--%>
                            <%--</c:forEach>--%>
                            </tbody>
                        </table>

                        <div class="example-wrap">
                            <div class="example">
                                <div class="fixed-table-pagination" style="display: block;">
                                    <div class="pull-left pagination-detail">
                                        <span class="pagination-info">显示第 1 到第 0 条记录，总共 0 条记录 每页显示</span>
                                    </div>
                                    <div class="pull-left pagination-detail">
                                        <select style="width: 75px;float: left; margin-right: 5px;"
                                                class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        <span class="pagination-info"> 条记录</span>
                                    </div>
                                    <div class="pull-right pagination" style="display: block;">
                                        <ul class="pagination pagination-outline">
                                            <li class="page-first disabled"><a href="javascript:void(0)">«</a></li>
                                            <li class="page-pre disabled"><a href="javascript:void(0)">‹</a></li>
                                            <li class="page-next disabled"><a href="javascript:void(0)">›</a></li>
                                            <li class="page-last disabled"><a href="javascript:void(0)">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <!-- End Example Events -->
            </div>
        </div>
    </div>
</div>
<!-- End Panel Other -->
</div>

<%--<script type="text/javascript" src="/js/jquery.min.js?v=2.1.4"></script>--%>
<%--<script type="text/javascript" src="/js/bootstrap.min.js?v=3.3.6"></script>--%>
<%--<script type="text/javascript" src="/js/content.min.js?v=1.0.0"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/sweetalert/sweetalert.min.js"></script>--%>
<%--<script type="text/javascript" src="/lib/zTree/js/jquery.ztree.all-3.5.js"></script>--%>
<%--<script type="text/javascript" src="/lib/zTree/js/jquery.ztree.exhide-3.5.min.js"></script>--%>
<%--<script type="text/javascript" src="/lib/qtip/jquery.qtip.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/validate/jquery.validate.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/plugins/wangEditor/js/wangEditor.min.js"></script>--%>
<%--<!--引入本地js-->--%>
<%--<script type="text/javascript" src="/js/common.js"></script>--%>
<%--<script type="text/javascript"  src="/js/module/item/list.js"></script>--%>
<jsp:include page="../common.jsp"></jsp:include>
</body>
</html>
