package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.UniversityService;
import com.cd.college.entity.UniversityEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.UniversityRepository;

@Service
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	private UniversityRepository univRepository;
	
	@Override
	public List<UniversityEntity> getUniversities() throws CollegeBusinessServiceException {
		List<UniversityEntity> universityEntities = null;
		try {
			universityEntities = univRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the universities", e);
		}
		return universityEntities;
	}

}
