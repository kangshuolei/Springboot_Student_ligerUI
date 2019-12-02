package com.student.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.CSRelationMapper;
import com.student.model.CSRelation;
import com.student.Service.CSRelationService;

@Service
public class CSRelationServiceImpl implements CSRelationService {
	@Autowired
	CSRelationMapper csRelationMapper;
	@Override
	public Integer addOne(CSRelation csRelation) {
		// TODO Auto-generated method stub
		return csRelationMapper.insertSelective(csRelation);
	}
	@Override
	public Integer delBySIdAndCSId(CSRelation csRelation) {
		// TODO Auto-generated method stub
		return csRelationMapper.delBySIdAndCSId(csRelation);
	}

}
