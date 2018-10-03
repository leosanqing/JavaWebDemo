<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="ErrorPage.jsp" %>
 <%@ include file="demo02.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	demo01<br>
	<jsp:forward page="demo02.jsp"></jsp:forward>
	<jsp:include page="demo02.jsp"></jsp:include>
	
</body>
</html>