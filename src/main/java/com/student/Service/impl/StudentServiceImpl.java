package com.student.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentMapper;
import com.student.model.Student;
import com.student.Service.StudentService;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public List<Student> getAll() {
		return studentMapper.getAll();
	}
	@Override
	public List<Student> getStudentByCourseId(Integer csId) {
		return studentMapper.getStudentByCourseId(csId);
	}
	@Override
	public List<Student> getStudentNotByCourseId(Integer csId) {
		return studentMapper.getStudentNotByCourseId(csId);
	}


	@Override
	public Integer addOne(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.insertSelective(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer modifyStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public Integer delStudentByIds(String ids) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKeys(ids);
	}
	@Override
	public List<Student> studentList(Integer sCode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Student> getListBysCode(Student student) {
		// TODO Auto-generated method stub
		System.out.println(studentMapper.getListBysCode(student));
		return studentMapper.getListBysCode(student);
	}
	

	


	
	


}
