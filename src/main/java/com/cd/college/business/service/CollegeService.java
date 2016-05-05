package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.CollegeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface CollegeService {

	 List<CollegeEntity> getColleges() throws CollegeBusinessServiceException; 
}
