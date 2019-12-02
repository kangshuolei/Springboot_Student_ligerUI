package com.student.Service;

import java.util.List;

import com.student.model.Student;


public interface StudentService {

	List<Student> getAll();

	List<Student> getStudentByCourseId(Integer csId);

	List<Student> getStudentNotByCourseId(Integer csId);
	
	Integer addOne(Student student);
	
	Student getStudentById(Integer id);
	
	Integer modifyStudent(Student student);
	
	Integer delStudentByIds(String ids);

	List<Student> studentList(Integer sCode);

	List<Student> getListBysCode(Student student);


















}
