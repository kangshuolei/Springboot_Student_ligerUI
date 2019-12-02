package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.Course;
import com.student.model.ResultEntity;
import com.student.model.ResultListEntity;
import com.student.Service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;

	
	@RequestMapping("toCourseListPage")
	public String toCourseListPage() {
		return "courseList";
	}

	@RequestMapping("getCourseList")
	@ResponseBody
	public ResultEntity<Course> getCourseList() {
		ResultEntity<Course> resultEntity = new ResultEntity<Course>();
		ResultListEntity<Course> resultList = new ResultListEntity<>();
		resultList.setRows(courseService.getAll());
		resultList.setTotal(100);
		
		resultEntity.setStatus("200");
		resultEntity.setResultListEntity(resultList);
		return resultEntity;
	}
	
	@RequestMapping("toAddCoursePage")
	public ModelAndView toAddCoursePage() {
		ModelAndView mv = new ModelAndView("addCourse");
		mv.addObject("course", new Course());
		return mv;
	}
	

	@RequestMapping("addCourse")
	@ResponseBody
	public ResultEntity addCourse(@RequestBody Course course) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Course> resultList = new ResultListEntity<>();
		try {
			courseService.addOne(course);
			resultList.setRows(courseService.getAll());
			resultList.setTotal(100);
			
			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}
	
	@RequestMapping("toModifyCoursePage/{id}")
	public ModelAndView toModifyStudentPage(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("addCourse");//addStudent是html页面的名称，连接到addStudent.html
		Course course = courseService.getCourseById(id);
		mv.addObject("course", course);
		return mv;
	}
	

	@RequestMapping("modifyCourse")
	@ResponseBody
	public ResultEntity modifyCourse(@RequestBody Course course) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Course> resultList = new ResultListEntity<>();
		try {
			courseService.modifyCourse(course);
			resultList.setRows(courseService.getAll());
			resultList.setTotal(100);

			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;//springboot springcloud
	}
	
	@RequestMapping("delCourse/{ids}")
	@ResponseBody
	public ResultEntity delCourse(@PathVariable String ids) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Course> resultList = new ResultListEntity<>();
		try {
//			Student student = new Student();
//			student.setIds(ids);
			courseService.delCourseByIds(ids);
			resultList.setRows(courseService.getAll());
			resultList.setTotal(100);

			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}	
	
	@RequestMapping("toGetStudentsByCoursePage/{type}/{csId}")
	public ModelAndView toGetStudentsByCoursePage(@PathVariable Integer type, 
			@PathVariable Integer csId) {
		ModelAndView mv = new ModelAndView("getStudentsByCourse");
		mv.addObject("csId", csId);
		mv.addObject("type", type);
		return mv;
	}
}
