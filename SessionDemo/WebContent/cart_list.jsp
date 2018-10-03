<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>您的购物车商品如下：</h2>
	<%
		Map<String,Integer> map=(Map<String,Integer>)session.getAttribute("cart");
		
		if(map!=null)
		{
			for(String key:map.keySet())
			{
				int value=map.get(key);
			
	%>		
			<h3>名称：<%=key %> 数量：<%=value %></h3>	
	<% 	
	
	
			}
		}
	%>
	
</body>
</html>