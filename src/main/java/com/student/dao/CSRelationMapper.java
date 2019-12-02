package com.student.dao;

import org.apache.ibatis.annotations.Mapper;

import com.student.model.CSRelation;
@Mapper
public interface CSRelationMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(CSRelation record);

    int insertSelective(CSRelation record);

    CSRelation selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(CSRelation record);

    int updateByPrimaryKey(CSRelation record);

	Integer delBySIdAndCSId(CSRelation csRelation);
}