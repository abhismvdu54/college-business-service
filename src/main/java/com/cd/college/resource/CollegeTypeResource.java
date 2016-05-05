package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.CollegeTypeService;
import com.cd.college.entity.CollegeTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeTypeResponse;
import com.cd.college.response.transformer.CollegeTypeResponseTransformer;

@RestController
@RequestMapping(value = "/college-type")
public class CollegeTypeResource {

	@Autowired
	private CollegeTypeResponseTransformer collegeTypeResponseTransformer;
	
	@Autowired
	private CollegeTypeService collegeTypeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody CollegeTypeResponse getCollegeTypes() {
		CollegeTypeResponse response = null;
		try {
			List<CollegeTypeEntity> listOfEntities = collegeTypeService.getCollegeTypes();
			//transform the entities into the corresponding dto objects
			return collegeTypeResponseTransformer.transformIntoCollegeTypeDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (CollegeTypeResponse) collegeTypeResponseTransformer.buildExceptionResponse(e, response);
		}
	}
}
