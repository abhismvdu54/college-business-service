package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.SubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface SubjectService {

	List<SubjectEntity> getSubjects() throws CollegeBusinessServiceException; 
}
