package Dao.dao.impl;

import Dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JDBCUtil;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User findUser(String userName) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.GetDataSource());
        String sql= "select * from user where name = ?";
        return queryRunner.query(sql,new BeanHandler<User>(User.class),userName);
    }

    @Override
    public User login(User user) throws SQLException {
        QueryRunner queryRunner= new QueryRunner(JDBCUtil.GetDataSource());
        String sql ="select * from user where name=? and password = ?";

        return queryRunner.query(sql,new BeanHandler<User>(User.class),user.getName(),user.getPassword());
    }
}
