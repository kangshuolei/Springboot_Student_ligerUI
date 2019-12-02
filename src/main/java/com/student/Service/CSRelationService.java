package com.student.Service;

import com.student.model.CSRelation;

public interface CSRelationService {

	Integer addOne(CSRelation csRelation);
	
	Integer delBySIdAndCSId(CSRelation csRelation);
}
