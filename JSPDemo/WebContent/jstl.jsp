<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List list =new ArrayList();
		list.add(new User("zhangsan",18));
		list.add(new User("lisi",19));
		list.add(new User("wang5",20));
		list.add(new User("zha",11));
		
		pageContext.setAttribute("list", list);
		
	%>
	
	${list[0] }
	<%-- <c:forEach items="${ list }" var="user">
		${user.name } -----------${user.age }
	</c:forEach> --%>
</body>
</html>