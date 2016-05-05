package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.ProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface ProgramService {

	 List<ProgramEntity> getPrograms() throws CollegeBusinessServiceException; 
}
