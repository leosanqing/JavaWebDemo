package cn.swu.stormleo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet04" , urlPatterns = "/Servlet04")
public class Servlet04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));

        System.out.println("收到了请求"+name+age);
        response.getWriter().write("这是一分数据");
    }
}
