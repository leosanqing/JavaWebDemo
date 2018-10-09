package autologin_filter;

import Dao.UserDao;
import Dao.dao.impl.UserDaoImpl;
import com.sun.deploy.net.HttpRequest;
import domain.User;
import util.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "AutoLoginFilter" ,urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            HttpServletRequest request= (HttpServletRequest) req;

            // 1. 先问Session失效了没

            User user=(User)request.getSession().getAttribute("User");
            if(user!=null){
                chain.doFilter(req,resp);
            }else{
                // Session 失效
                // 查找cookie
                // 1. 取出 cookie
                Cookie [] cookies=request.getCookies();
                Cookie cookie=CookieUtil.findCookie(cookies,"auto_login");
                if(cookie==null){
                    chain.doFilter(req, resp);
                }else
                {

                    // 3.获取cookie的值
                    String value= cookie.getValue();
                    String username=value.split("#")[0];
                    String password=value.split("#")[1];

                    User userBean=new User();
                    userBean.setName(username);
                    userBean.setPassword(password);

                    UserDao  dao= new UserDaoImpl();
                    user = dao.login(userBean);

                    // 4.将数据存入Session
                    request.getSession().setAttribute("User",user);

                    chain.doFilter(req,resp);

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
