<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/11/14
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <link href="/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body>
    <h1 style="margin-left: 41%;font-size: 48px;">智运会答题</h1>
    <ul class="list-group">
        <c:forEach items="${list}" var="l">
            <li class="list-group-item" style="height:250px; font-size: 24px;"><label>${l.id}.${l.textdosc}</label><input type="hidden" value="${l.textanswer}">
                <button class="btn btn-primary btn-lg" style="float: right" data-toggle="modal" data-target="#myModal">
                    查看
                </button>
            </li>
        </c:forEach>
    </ul>
    <h2><a href="/edit?id=10" style="float: right; margin-right: 100px;">升级难度</a></h2>
    <h2><a href="/reset" style="float: right; margin-right: 100px;">返回抽题</a></h2>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        答案
                    </h4>
                </div>
                <div id="modal-text" class="modal-body" style="font-size: 24px;">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">确定
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
<script>
    $(".btn-lg").click(function () {
        $("#modal-text").text($(this).prev().val());
    })
</script>
</body>
</html>
