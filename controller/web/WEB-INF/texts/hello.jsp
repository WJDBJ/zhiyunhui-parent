<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/11/14
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <link href="/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<h1 style="margin-left: 36.5%;font-size: 48px;">欢迎参加智运会</h1>
<form action="/hello" style="float: right; margin-right: 100px; ">
    <input type="submit"  class="btn btn-danger" value="重置"/>
</form>
<form action="/answer">
    <input type="submit" style="height: 250px;width: 400px;text-align: center;font-size: 48px;margin-left: 34%;
    margin-top: 100px;" class="btn btn-info btn-lg" value="开始答题"/>
</form>
<br/>
</body>
</html>
