package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.ProgramSpecialisationSubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface ProgramSpecialisationSubjectService {
	List<ProgramSpecialisationSubjectEntity> getProgramSpecialisationSubjects() throws CollegeBusinessServiceException; 

}
