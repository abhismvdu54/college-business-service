package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.UniversityTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface UniversityTypeService {
	List<UniversityTypeEntity> getUniversityTypes() throws CollegeBusinessServiceException;
}
