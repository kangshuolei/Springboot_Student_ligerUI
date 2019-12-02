package com.student.Service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Service.UserService;
import com.student.dao.UserMapper;
import com.student.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Override
	public boolean getUserByName(User user, HttpSession session) {
		user = userMapper.selectByNameAndPWD(user);
		System.out.println(user);
		if (user != null) {
			session.setAttribute("currentUser", user);
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String uName() {
		// TODO Auto-generated method stub
		return userMapper.getuName();
	}
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}
	@Override
	public String getuPwd() {
		// TODO Auto-generated method stub
		return userMapper.getuPwd();
	}

}
