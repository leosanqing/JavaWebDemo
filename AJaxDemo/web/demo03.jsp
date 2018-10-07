<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校验用户名</title>

    <script type="text/javascript">

        function ajaxFunction(){
            var xmlHttp;
            try{ // Firefox, Opera 8.0+, Safari
                xmlHttp=new XMLHttpRequest();
            }
            catch (e){
                try{// Internet Explorer
                    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e){
                    try{
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e){}
                }
            }

            return xmlHttp;
        }
        function checkUserName() {

             // 1.创建连接
            var request = ajaxFunction();
            // 2.获取输入框中的值
            var name=document.getElementById("name").value;

            request.onreadystatechange = function () {
                if (request.readyState==4&&request.status==200)
                {
                    var data=request.responseText;
                    alert(""+data+name);
                    if (data == 1){
                        document.getElementById("span1").innerHTML=" <font color='red'>用户名已存在</font>";
                    }else{
                        document.getElementById("span1").innerHTML=" <font color='#00ff7f'>用户名可用</font>";
                    }

                }

            }
            request.open("POST","CheckUserNameServlet",true);
            request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            request.send("name="+name);
        }



    </script>
</head>

<body>
    <form action="">
        <table align="center" width="500" border="2">
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
