package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.ProgramService;
import com.cd.college.entity.ProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService{

	@Autowired
	private ProgramRepository programRepository;
	
	@Override
	public List<ProgramEntity> getPrograms() throws CollegeBusinessServiceException {
		List<ProgramEntity> programEntities = null;
		try {
			programEntities = programRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the programs", e);
		}
		return programEntities;
	}

}
