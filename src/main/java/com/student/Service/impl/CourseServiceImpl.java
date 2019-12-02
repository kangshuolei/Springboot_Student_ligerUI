package com.student.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.CourseMapper;
import com.student.model.Course;
import com.student.Service.CourseService;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseMapper courseMapper;

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return courseMapper.getAll();
	}

	@Override
	public Integer addOne(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.insertSelective(course);
	}

	@Override
	public Course getCourseById(Integer id) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer modifyCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.updateByPrimaryKeySelective(course);
	}

	@Override
	public Integer delCourseByIds(String ids) {
		// TODO Auto-generated method stub
		return courseMapper.deleteByPrimaryKeys(ids);
	}

}
