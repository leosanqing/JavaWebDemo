package cn.swu.stormleo.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.swu.stormleo.dao.StudentDao;
import cn.swu.stormleo.domain.Student;
import cn.swu.stormleo.util.JDBCUtil;

/**
 *  StudentDao d使得实现
 * @author stormleo
 *
 */

public class StudentDaoImpl implements StudentDao
{

	@Override
	public List<Student> findAll() throws SQLException
	{
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.GetDataSource());
		String sql="select * from stu";
		List<Student> list=queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void addStu(Student student) throws SQLException
	{
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.GetDataSource());
		String sql="insert into stu values(null,?,?,?,?,?,?)";
		queryRunner.update(sql, 
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}	
	
}
