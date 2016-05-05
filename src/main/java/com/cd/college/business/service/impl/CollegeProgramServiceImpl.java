package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.CollegeProgramService;
import com.cd.college.entity.CollegeProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.CollegeProgramRepository;

@Service
public class CollegeProgramServiceImpl implements CollegeProgramService{

	@Autowired
	private CollegeProgramRepository collegeProgramRepository;
	
	@Override
	public List<CollegeProgramEntity> getCollegePrograms() throws CollegeBusinessServiceException {
		List<CollegeProgramEntity> collegeProgramEntities = null;
		try {
			collegeProgramEntities = collegeProgramRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the college programs", e);
		}
		return collegeProgramEntities;
	}
	
}
