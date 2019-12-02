package com.student.Service;

import javax.servlet.http.HttpSession;

import com.student.model.User;

public interface UserService {

	boolean getUserByName(User user, HttpSession session);

	String uName();

	void insert(User user);

	String getuPwd();

}
