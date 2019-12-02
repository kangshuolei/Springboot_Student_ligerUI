package com.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.student.model.Course;
@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer csId);
    int deleteByPrimaryKeys(String sId);
    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer csId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	List<Course> getAll();

	
}