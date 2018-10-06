package cn.swu.stormleo.dao;

import java.sql.SQLException;
import java.util.List;

import cn.swu.stormleo.domain.Student;

public interface StudentDao
{
	List<Student> findAll() throws SQLException;
	
	void addStu(Student student) throws SQLException;
}
