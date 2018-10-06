package cn.swu.stormleo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.catalina.connector.Request;

import cn.swu.stormleo.domain.Student;
import cn.swu.stormleo.service.StudentService;
import cn.swu.stormleo.service.impl.StudentServiceImpl;



/**
 * 查询所有学生的信息
 * @author stormleo
 *
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	List <Student> list=null;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 查询数据
		StudentService service = new StudentServiceImpl();
		list = service.findAll();
		
		// 2. 把数据放进服务器中
		request.getSession().setAttribute("list", list);
		
		// 3.跳转页面
		response.sendRedirect("list.jsp");
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	
	
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
