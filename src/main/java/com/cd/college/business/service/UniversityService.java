package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.UniversityEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface UniversityService {
	List<UniversityEntity> getUniversities() throws CollegeBusinessServiceException;

}
