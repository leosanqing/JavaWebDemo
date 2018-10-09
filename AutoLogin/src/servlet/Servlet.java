package servlet;

import Dao.UserDao;
import Dao.dao.impl.UserDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "servlet.Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("已进入到servlet");
            UserDao dao= new UserDaoImpl();

            String username = request.getParameter("name");
            String password = request.getParameter("password");
            String autoLogin = request.getParameter("auto");

            User userBean =new User();
            userBean.setName(username);
            userBean.setPassword(password);

            System.out.println(username+"========"+password);
            User user=dao.login(userBean);

            // 将值存到session
            request.getSession().setAttribute("User",user);
            if (user !=null) {

                if("on".equals(autoLogin))
                {
                    Cookie cookie= new Cookie("auto_login",user.getName()+"#"+user.getPassword());
                    cookie.setMaxAge(60*60*24*7);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
                response.sendRedirect("web02.jsp");
            }else{
                response.sendRedirect("web02.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
