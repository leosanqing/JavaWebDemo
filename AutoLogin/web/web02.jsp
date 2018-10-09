<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/9
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty User}">
         这是web02 欢迎您${User.name};
    </c:if>

    <c:if test="${ empty User}">
        这是web02 <a href="index.jsp" >请登录</a>
    </c:if>
</body>
</html>
