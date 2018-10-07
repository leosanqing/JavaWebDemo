<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post请求</title>


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

        function post() {
            // 1.创建 xmlHttp
            var request = ajaxFunction();

            //2. 发送请求
            request.open("POST", "ServletDemo02", true);

            // 3.获取响应
            request.onreadystatechange = function(){
                if (request.readyState==4&& request.status==200)
                    alert("数据")
            }

            // 设置头
            request.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            request.send("name=leosanqing&age=21");
        }

    </script>
</head>


<body>
    <h3><a href="" onclick="post()" >发送请求</a></h3>
</body>
</html>
