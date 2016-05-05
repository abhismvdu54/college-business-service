package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.CollegeProgramSpecialisationService;
import com.cd.college.entity.CollegeProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.CollegeProgramSpecialisationRepository;

@Service
public class CollegeProgramSpecialisationServiceImpl implements CollegeProgramSpecialisationService{

	@Autowired
	private CollegeProgramSpecialisationRepository collegeProgramSpecialisationRepository; 
	
	@Override
	public List<CollegeProgramSpecialisationEntity> getCollegeProgramSpecialisations() throws CollegeBusinessServiceException{
	List<CollegeProgramSpecialisationEntity> entities = null;
	try {
		entities = collegeProgramSpecialisationRepository.findAll();
	} catch (Exception e) {
		throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Unable to retrieve college program specialisation", e);
	}
	return entities;
	}

}
