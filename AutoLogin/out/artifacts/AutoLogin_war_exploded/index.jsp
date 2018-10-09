<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/9
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      这是index 界面
    <form action="/Servlet">
        用户名：<input type="text" name="name"><br>
        密码：<input type="password" name="password"><br>
              <input type="checkbox" name="auto"> 自动登录<br>
        <input type="submit" value="提交">
    </form>
  </body>
</html>
