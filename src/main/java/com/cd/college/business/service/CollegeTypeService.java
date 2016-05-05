package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.CollegeTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface CollegeTypeService {

	List<CollegeTypeEntity> getCollegeTypes() throws CollegeBusinessServiceException;
}
