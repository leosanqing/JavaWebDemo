package cn.swu.stormleo.loginDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginDemo")
public class loginDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		if(userName.equals("admin") && password.equals("123"))
		{
			System.out.println("123456");
//			//重定向写法
//			response.sendRedirect("login_success.html");
//			
			// 请求转发写法
			request.getRequestDispatcher("login_success.html").forward(request, response);
		}
		else
		{
			response.getWriter().write("登录失败");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
