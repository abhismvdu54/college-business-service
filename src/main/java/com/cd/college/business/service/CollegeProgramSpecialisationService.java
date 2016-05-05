package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.CollegeProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface CollegeProgramSpecialisationService {

	 List<CollegeProgramSpecialisationEntity> getCollegeProgramSpecialisations() throws CollegeBusinessServiceException; 
}
