package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.DegreeService;
import com.cd.college.entity.DegreeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.DegreeRepository;

@Service
public class DegreeServiceImpl implements DegreeService{

	@Autowired
	private DegreeRepository degreeRepository;
	
	@Override
	public List<DegreeEntity> getDegrees() throws CollegeBusinessServiceException {
		List<DegreeEntity> degreeEntities = null;
		try {
			degreeEntities = degreeRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the degrees", e);
		}
		return degreeEntities;
	}

}
