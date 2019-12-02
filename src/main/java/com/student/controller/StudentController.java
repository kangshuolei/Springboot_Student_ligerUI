package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.CSRelation;
import com.student.model.ResultEntity;
import com.student.model.ResultListEntity;
import com.student.model.Student;
import com.student.Service.CSRelationService;
import com.student.Service.StudentService;


@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	CSRelationService csrelationService;

	
	
	@RequestMapping("toStudentListPage")
	public String toStudentListPage() {
		return "studentList";
	}
	
	@RequestMapping("getStudentList")
	@ResponseBody
	public ResultEntity<Student> getStudentList() {
		ResultEntity<Student> resultEntity = new ResultEntity<Student>();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
		resultList.setRows(studentService.getAll());
		resultList.setTotal(100);
		
		resultEntity.setStatus("200");
		resultEntity.setResultListEntity(resultList);
		return resultEntity;
	}
	
	@RequestMapping("getStudentListByCourse/{type}/{csId}")
	@ResponseBody
	public ResultEntity<Student> getStudentListByCourse(@PathVariable Integer type,
			@PathVariable Integer csId) {
		ResultEntity<Student> resultEntity = new ResultEntity<Student>();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
		if(type != null && type == 1) { //查看没有选择该课程的学生列表
			resultList.setRows(studentService.getStudentNotByCourseId(csId));
		}else if(type != null && type == 2){//查看选择该课程的学生列表
			resultList.setRows(studentService.getStudentByCourseId(csId));
		}
		resultList.setTotal(100);
		
		resultEntity.setStatus("200");
		resultEntity.setResultListEntity(resultList);
		return resultEntity;
	}
	

	@RequestMapping("toAddStudentPage")
	public ModelAndView toAddStudentPage() {
		ModelAndView mv = new ModelAndView("addStudent");
		mv.addObject("student", new Student());
		return mv;
	}
	

	@RequestMapping("addStudent")
	@ResponseBody
	public ResultEntity addStudent(@RequestBody Student student) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
		try {
			studentService.addOne(student);
			resultList.setRows(studentService.getAll());
			resultList.setTotal(100);
			
			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}
	

	@RequestMapping("toModifyStudentPage/{id}")
	public ModelAndView toModifyStudentPage(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("addStudent");//addStudent是html页面的名称，连接到addStudent.html
		Student student = studentService.getStudentById(id);
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping("modifyStudent")
	@ResponseBody
	public ResultEntity modifyStudent(@RequestBody Student student) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
		try {
			studentService.modifyStudent(student);
			resultList.setRows(studentService.getAll());
			resultList.setTotal(100);

			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;//springboot springcloud
	}
	
	@RequestMapping("delStudent/{ids}")
	@ResponseBody
	public ResultEntity delStudent(@PathVariable String ids) {	
		ResultEntity resultEntity = new ResultEntity();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
		try {
//			Student student = new Student();
//			student.setIds(ids);
			studentService.delStudentByIds(ids);
			resultList.setRows(studentService.getAll());
			resultList.setTotal(100);

			resultEntity.setStatus("200");
			resultEntity.setResultListEntity(resultList);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}
	
	@RequestMapping("addStudentToCourse/{ids}/{csId}")
	@ResponseBody
	public ResultEntity addStudentToCourse(@PathVariable String ids,
			@PathVariable Integer csId) {	
		ResultEntity resultEntity = new ResultEntity();
		try {
			String[] idArr = ids.split(",");
			for (String sId : idArr) {
				CSRelation csr = new CSRelation();
				csr.setcId(csId);
				csr.setsId(Integer.parseInt(sId));
				csrelationService.addOne(csr);
			}
			resultEntity.setStatus("200");
		}catch(Exception e) {
			resultEntity.setStatus("500");
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}
	
	/**
	 * 删除某个课程的学生 restful      url?name=zhangsan&pwd=123
	 * @param ids 需要删除的学生ids字符串，以“，”分割
	 * @param csId
	 * @return
	 */
	@RequestMapping("delStudentToCourse/{ids}/{csId}")
	@ResponseBody
	public ResultEntity delStudentToCourse(@PathVariable String ids,
			@PathVariable Integer csId) {	
		ResultEntity resultEntity = new ResultEntity();
		try {
			String[] idArr = ids.split(",");
			for (String sId : idArr) {
				CSRelation csr = new CSRelation();
				csr.setcId(csId);
				csr.setsId(Integer.parseInt(sId));
				csrelationService.delBySIdAndCSId(csr);
			}
			resultEntity.setStatus("200");
		}catch(Exception e) {
			resultEntity.setStatus("500");
			e.printStackTrace();
			return null;
		}
		return resultEntity;
	}
	
	
	@RequestMapping("getStudentsCode")
	@ResponseBody
	public ResultEntity <Student> getStudentsCode(@RequestBody Student student) {
		ResultEntity<Student> resultEntity = new ResultEntity<Student>();
		ResultListEntity<Student> resultList = new ResultListEntity<>();
	
	     resultList.setRows(studentService.getListBysCode(student));
	/*	resultList.setRows(studentService.getAll());*/
	 
		resultList.setTotal(100);
		
		resultEntity.setStatus("200");
		resultEntity.setResultListEntity(resultList);
		
		return resultEntity;
		
   
	/*	return new ResultEntity();*/
	}
	
}
