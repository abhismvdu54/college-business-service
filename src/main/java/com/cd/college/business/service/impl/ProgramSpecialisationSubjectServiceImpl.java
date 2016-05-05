package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.ProgramSpecialisationSubjectService;
import com.cd.college.entity.ProgramSpecialisationSubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.ProgramSpecialisationSubjectRepository;

@Service
public class ProgramSpecialisationSubjectServiceImpl implements ProgramSpecialisationSubjectService {

	@Autowired
	private ProgramSpecialisationSubjectRepository programSpecialisationSubjectRepository; 
	
	@Override
	public List<ProgramSpecialisationSubjectEntity> getProgramSpecialisationSubjects()
			throws CollegeBusinessServiceException {
		List<ProgramSpecialisationSubjectEntity> programSpecialisationSubjectEntities = null;
		try {
			programSpecialisationSubjectEntities = programSpecialisationSubjectRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the program specialisation subjects", e);
		}
		return programSpecialisationSubjectEntities;
	}

}
