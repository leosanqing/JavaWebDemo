<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JQuery方法校验用户名</title>

    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

    <script type="text/javascript">
        function checkUserName() {
            var name = $("#name").val();
            $.post("CheckUserNameServlet",{name:name},function (data,status) {
               if (data==1){
                   $("#span1").html("<font color='red'>此用户名已存在</font>");
               }else{
                   $("#span1").html("<font color='#00ff7f'>此用户名可用</font>");

               }
            });
        }

    </script>
</head>
<body>
    <form action="">
        <table align="center" width="700" border="2">
            <tr align="center">
                <td>姓名</td>
                <td><input type="text" name="name" id="name" onblur="checkUserName()"> <span id="span1"></span></td>
            </tr>
            <tr align="center">
                <td>密码</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr align="center">
                <td>年龄</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="提交"></td>

            </tr>
        </table>
    </form>
</body>
</html>
