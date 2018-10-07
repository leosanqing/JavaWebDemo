package cn.swu.stormleo.servlet;

import cn.swu.stormleo.dao.UserDao;
import cn.swu.stormleo.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckUserNameServlet",urlPatterns = "/CheckUserNameServlet" )
public class CheckUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            String name=request.getParameter("name");
            System.out.println("的到name"+name);
            UserDao dao =new UserDaoImpl();
            boolean isExist = dao.checkUser(name);

            if(isExist)
            {
                response.getWriter().print(1);
            }else {
                response.getWriter().print(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
