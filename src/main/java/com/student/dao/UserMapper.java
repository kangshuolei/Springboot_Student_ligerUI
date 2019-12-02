package com.student.dao;
import org.apache.ibatis.annotations.Mapper;

import com.student.model.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByNameAndPWD(User user);

	String getuPwd();

	String getuName();
}