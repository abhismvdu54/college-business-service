package com.cd.college.business.service;

import java.util.List;

import com.cd.college.entity.DegreeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;

public interface DegreeService {

	List<DegreeEntity> getDegrees() throws CollegeBusinessServiceException;
}
