package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.UniversityService;
import com.cd.college.entity.UniversityEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.UniversityResponse;
import com.cd.college.response.transformer.UniversityResponseTransformer;

@RestController
@RequestMapping(value = "/university")
public class UniversityResource {

	@Autowired
	private UniversityResponseTransformer universityResponseTransformer;
	
	@Autowired
	private UniversityService universityService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody UniversityResponse getUniversities() {
		UniversityResponse response = null;
		try {
			List<UniversityEntity> listOfEntities = universityService.getUniversities();
			//transform the entities into the corresponding dto objects
			return universityResponseTransformer.transformIntoCollegeTypeDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (UniversityResponse) universityResponseTransformer.buildExceptionResponse(e, response);
		}
	}
	
}
