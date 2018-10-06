package cn.swu.stormleo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.stormleo.domain.Student;
import cn.swu.stormleo.service.StudentService;
import cn.swu.stormleo.service.impl.StudentServiceImpl;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 1.获取数据
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		String hobby=request.getParameter("hobby");
		String info=request.getParameter("info");
		
		
		
		try
		{
			
			System.out.println("已得到数据"+birthday);
			// 2.添加到数据库
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student= new Student(sname,gender,phone,date,hobby,info);
			StudentService service= new StudentServiceImpl();
			service.addStu(student);
			
			// 3.跳转界面.   request 不仅能跳 jsp 也能跳 Servlet
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
