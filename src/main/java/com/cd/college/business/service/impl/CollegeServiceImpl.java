package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.CollegeService;
import com.cd.college.entity.CollegeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeRepository collegeRepository;
	
	@Override
	public List<CollegeEntity> getColleges() throws CollegeBusinessServiceException {
		List<CollegeEntity> collegeEntities = null;
		try {
			collegeEntities = collegeRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the colleges", e);
		}
		return collegeEntities;
	}

}
