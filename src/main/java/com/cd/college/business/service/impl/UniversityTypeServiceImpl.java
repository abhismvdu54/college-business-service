package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.UniversityTypeService;
import com.cd.college.entity.UniversityTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.UniversityTypeRepository;

@Service
public class UniversityTypeServiceImpl implements UniversityTypeService{

	@Autowired
	private UniversityTypeRepository universityTypeRepository;
	
	@Override
	public List<UniversityTypeEntity> getUniversityTypes() throws CollegeBusinessServiceException {
		List<UniversityTypeEntity> universityTypeEntities = null;
		try {
			universityTypeEntities = universityTypeRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the university types", e);
		}
		return universityTypeEntities;
	}

}
