package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.ProgramSpecialisationService;
import com.cd.college.entity.ProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.ProgramSpecialisationRepository;

@Service
public class ProgramSpecialisationServiceImpl implements ProgramSpecialisationService{

	@Autowired
	private ProgramSpecialisationRepository programSpecialisationRepository;
	@Override
	public List<ProgramSpecialisationEntity> getProgramSpecialisations() throws CollegeBusinessServiceException {
		List<ProgramSpecialisationEntity> programSpecialisationEntities = null;
		try {
			programSpecialisationEntities = programSpecialisationRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the colleges", e);
		}
		return programSpecialisationEntities;
	}

}
