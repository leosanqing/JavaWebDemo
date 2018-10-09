package Dao;

import domain.User;

import java.sql.SQLException;

public interface UserDao {
    User findUser(String userName) throws SQLException;
    User login(User user) throws SQLException;
}
