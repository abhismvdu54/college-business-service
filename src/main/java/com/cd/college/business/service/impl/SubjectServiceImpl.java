package com.cd.college.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.business.service.SubjectService;
import com.cd.college.entity.SubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public List<SubjectEntity> getSubjects() throws CollegeBusinessServiceException {
		List<SubjectEntity> subjectEntities = null;
		try {
			subjectEntities = subjectRepository.findAll();
		} catch (Exception e) {
			throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Unable to retrieve the subjects", e);
		}
		return subjectEntities;
	}

}
