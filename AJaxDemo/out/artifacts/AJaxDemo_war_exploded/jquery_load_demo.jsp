<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是JQuery的load demo</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">
        function load() {
            $("#text1").load("Servlet04",function(responseTxt,statusTxt,xhr){
                    $("#text1").val(responseTxt)
            });
        }
        
    </script>
</head>
<body>
    <input type="button" onclick="load()" value="这是一个按钮">
    <input type="text" id="text1">

</body>
</html>
