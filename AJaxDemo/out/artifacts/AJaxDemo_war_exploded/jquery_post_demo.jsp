<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是JQuery的 post demo</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">
        function post() {
            $.get("Servlet04", {name:"leosanqing",age:"21"},function (data, status) {
                alert("Data: " + data + "\nStatus: " + status);
                $("#div1").html("data"+data+"status"+status);
            });
        }

    </script>
</head>
<body>
<input type="button" onclick="post()" value="post">
<div id="div1" style="width: 100px; height: 200px;border: 1px springgreen solid">

</div>
</body>
</html>
