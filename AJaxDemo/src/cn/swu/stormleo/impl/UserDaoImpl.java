package cn.swu.stormleo.impl;

import cn.swu.stormleo.dao.UserDao;
import cn.swu.stormleo.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkUser(String userName) throws SQLException {
        QueryRunner queryRunner =new QueryRunner(JDBCUtil.GetDataSource());

        String sql="select count(*) from user where name=?";
       Long result= (Long)queryRunner.query(sql, new ScalarHandler(),userName);
        return result>0;
    }
}
