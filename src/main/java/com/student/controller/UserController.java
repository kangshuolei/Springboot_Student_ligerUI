package com.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.Service.UserService;
import com.student.model.ResultEntity;
import com.student.model.User;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("toregister")
	public String toregister() {
		return "register";
	}

	@RequestMapping("register")
	@ResponseBody
	public String register(@RequestBody User user) {
		try {
			userService.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "注册失败，服务器忙，请稍后重试.";
		}

		return "注册成功";

	}

	@RequestMapping("login")
	@ResponseBody
	public ResultEntity<User> login(@RequestBody User user, HttpSession session) {
		ResultEntity<User> re = new ResultEntity<>();
		System.out.println(user);
		if (userService.getUserByName(user, session)) {
			re.setStatus("200");
			re.setMsg("登录成功");
		} else {
			re.setStatus("201");
			re.setMsg("用户名或密码错误");
		}
		return re;
	}

	@RequestMapping("toMainPage")
	public ModelAndView toMainPage(HttpSession session) {
		ModelAndView mv;
		if (session.getAttribute("currentUser") != null) {
			mv = new ModelAndView("main");
			mv.addObject("currentUser", session.getAttribute("currentUser"));
		} else {
			mv = new ModelAndView("index");
		}
		return mv;
	}

}
