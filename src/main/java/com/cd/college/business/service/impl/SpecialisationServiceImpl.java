package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.SpecialisationService;
import com.cd.college.entity.SpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.SpecialisationRepository;

@Service
public class SpecialisationServiceImpl implements SpecialisationService{

	@Autowired
	private SpecialisationRepository specialisationRepository;
	
	@Override
	public List<SpecialisationEntity> getSpecialisations() throws CollegeBusinessServiceException {
		List<SpecialisationEntity> specialisationEntities = null;
		try {
			specialisationEntities = specialisationRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the specialisations", e);
		}
		return specialisationEntities;
	}

}
