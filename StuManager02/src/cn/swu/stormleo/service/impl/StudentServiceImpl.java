package cn.swu.stormleo.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.swu.stormleo.dao.StudentDao;
import cn.swu.stormleo.dao.impl.StudentDaoImpl;
import cn.swu.stormleo.domain.Student;
import cn.swu.stormleo.service.StudentService;


/**
 * 这是学生业务实现
 * @author stormleo
 *
 */

public class StudentServiceImpl implements StudentService
{

	@Override
	public List<Student> findAll() throws SQLException
	{
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void addStu(Student student) throws SQLException
	{
		StudentDao dao =new StudentDaoImpl();
		dao.addStu(student);
	}


	

}
