package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.UniversityTypeService;
import com.cd.college.entity.UniversityTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeTypeResponse;
import com.cd.college.response.UniversityTypeResponse;
import com.cd.college.response.transformer.UniversityTypeResponseTransformer;

@RestController
@RequestMapping(value = "/university-type")
public class UniversityTypeResource {

	@Autowired
	private UniversityTypeResponseTransformer universityTypeResponseTransformer;
	
	@Autowired
	private UniversityTypeService universityTypeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody UniversityTypeResponse getCollegeTypes() {
		CollegeTypeResponse response = null;
		try {
			List<UniversityTypeEntity> listOfEntities = universityTypeService.getUniversityTypes();
			//transform the entities into the corresponding dto objects
			return universityTypeResponseTransformer.transformIntoUniversityTypeDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (UniversityTypeResponse) universityTypeResponseTransformer.buildExceptionResponse(e, response);
		}
	}
	
}
