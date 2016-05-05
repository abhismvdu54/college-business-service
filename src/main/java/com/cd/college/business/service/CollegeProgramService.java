package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.CollegeProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface CollegeProgramService {
	List<CollegeProgramEntity> getCollegePrograms() throws CollegeBusinessServiceException; 

}
