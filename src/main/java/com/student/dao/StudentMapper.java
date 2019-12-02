package com.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.student.model.Student;
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKeys(String sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	List<Student> getAll();
	List<Student> getStudentByCourseId(Integer csId);
	List<Student> getStudentNotByCourseId(Integer csId);
	
	
	List<Student> getListBysCode(Student student);




	
}