package cn.swu.stormleo.loginDemo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.stormleo.Utils.CookieUtil;

@WebServlet("/demo03")
public class demo03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if("admin".equals(userName)&&"123".equals(password))
		{
			Cookie cookies []=request.getCookies();
			Cookie cookie=CookieUtil.findCookie(cookies, "last");
			// 第一次登录
			if(cookie==null)
			{
				Cookie c=new Cookie("last",System.currentTimeMillis()+"");
				c.setMaxAge(60*60);
				response.addCookie(c);
			}else {
				// 第二次登录
				
				// 获取上次的时间
				Long lastVisiteTime=Long.parseLong(cookie.getValue());
				response.getWriter().write("欢迎您"+userName+",上次来访时间是："+new Date(lastVisiteTime));
				// 重置 last 时间
				cookie.setValue(System.currentTimeMillis()+"");
				response.addCookie(cookie);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
