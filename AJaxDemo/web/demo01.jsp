<%--
  Created by IntelliJ IDEA.
  User: stormleo
  Date: 2018/10/7
  Time: 13:56
  To change this template use File | Settings | File Templates.

  get请求获取  AJAX
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是一个AJax的demo</title>
</head>

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

    function get() {
        // 1.创建 xmlHttp
        var request = ajaxFunction();

        //2. 发送请求
        request.open("GET", "ServletDemo01?name=zhupipi&age=18", true);

        // 3. 响应请求
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                alert("收到了请求")
            }
        }
        request.send();
    }
</script>
<body>
            <h3><a href="" onclick="get()" >发送请求</a></h3>
</body>
</html>
