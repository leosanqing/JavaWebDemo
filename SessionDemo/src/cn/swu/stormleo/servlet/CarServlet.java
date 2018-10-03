package cn.swu.stormleo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		
		// 获取商品的Id
		int id=Integer.parseInt(request.getParameter("id"));
		String names[]= {"iPhone","小米","三星note9","华为荣耀","诺基亚"};
		
		String name=names[id];
		
		// 2 获取购物车存放东西的 Session 
		Map<String ,Integer> map=(Map<String, Integer>) request.getSession().getAttribute("cart");
		
		if(map==null)
		{
			map=new LinkedHashMap<String,Integer>();
			request.getSession().setAttribute("cart",map);
			
		}
		
		// 判断购物车中有没有该商品
		
		if(map.containsKey(name))
		{
			map.put(name, map.get(name)+1);
		}else {
			map.put(name, 1);
		}
		
		
		// 跳转界面
		
		response.getWriter().write("<a href='product_list.jsp'><h1>返回购物</h1></a><br>");
		response.getWriter().write("<a href='cart_list.jsp'><h1>去购物车</h1></a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
