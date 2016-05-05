package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.SpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface SpecialisationService {
	
	 List<SpecialisationEntity> getSpecialisations() throws CollegeBusinessServiceException; 
}
