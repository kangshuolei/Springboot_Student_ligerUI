package com.student.Service;

import java.util.List;

import com.student.model.Course;


public interface CourseService {
	List<Course> getAll();
	
	Integer addOne(Course course);
	
	Course getCourseById(Integer id);
	
	Integer modifyCourse(Course course);
	
	Integer delCourseByIds(String ids);
}
