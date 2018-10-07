<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是jQuery get demo</title>
    <script src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">
        function get() {
            $.get("Servlet04", function (data, status) {
                alert("Data: " + data + "\nStatus: " + status);
                $("#div1").html("data"+data+"status"+status);
            });
        }

    </script>
</head>
<body>
    <input type="button" onclick="get()" value="get">
    <div id="div1" style="width: 100px; height: 200px;border: 1px springgreen solid">

    </div>
</body>
</html>
