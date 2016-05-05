package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.ProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface ProgramSpecialisationService {
	List<ProgramSpecialisationEntity> getProgramSpecialisations() throws CollegeBusinessServiceException;

}
