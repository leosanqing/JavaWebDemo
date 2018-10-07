package cn.swu.stormleo.dao;


import java.sql.SQLException;

public interface UserDao {
    /**
     * 检测用户名是否存在
     * @param userName
     * @return
     */
    boolean checkUser(String userName) throws SQLException;
}
