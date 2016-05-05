package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.CollegeTypeService;
import com.cd.college.entity.CollegeTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.CollegeTypeRepository;

@Service
public class CollegeTypeServiceImpl implements CollegeTypeService {

	@Autowired
	private CollegeTypeRepository collegeTypeRepository;
	
	@Override
	public List<CollegeTypeEntity> getCollegeTypes() throws CollegeBusinessServiceException {
		List<CollegeTypeEntity> collegeTypeEntities = null;
		try {
			collegeTypeEntities = collegeTypeRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the college types", e);
		}
		return collegeTypeEntities;
	}

}
