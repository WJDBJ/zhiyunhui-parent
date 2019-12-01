<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/11/21
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${error}</h1>
    <a href="/reset">返回答题界面</a>
    <form action="/insertTest" >
        文件路径<input type="text" name="path"  autocomplete="off"  value="${path}"/>
        <input type="submit" value="测试文档数据"/>
    </form>
    <form action="/insert" >
        文件路径<input type="text" autocomplete="off" name="path"/>
        <input type="submit" value="添加新题"/>
    </form>
    <h1>${list[0].textdosc}</h1>
    <textarea style="width: 1200px; height: 800px;">
        <c:forEach items="${list}" var="l">
            ${l.textdosc}------${l.textanswer}
        </c:forEach>
    </textarea>
</body>
</html>
