package cn.swu.stormleo.service;

import java.sql.SQLException;
import java.util.List;

import cn.swu.stormleo.domain.Student;

public interface StudentService
{
	List<Student> findAll() throws SQLException;
	void addStu(Student student) throws SQLException;
}
