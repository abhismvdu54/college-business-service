package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.CollegeService;
import com.cd.college.entity.CollegeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeResponse;
import com.cd.college.response.transformer.CollegeResponseTransformer;

@RestController
@RequestMapping(value = "/college")
public class CollegeResource {

	@Autowired
	private CollegeResponseTransformer collegeResponseTransformer;
	
	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody CollegeResponse getColleges() {
		CollegeResponse response = null;
		try {
			List<CollegeEntity> listOfEntities = collegeService.getColleges();
			//transform the entities into the corresponding dto objects
			return collegeResponseTransformer.transformIntoCollegeDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (CollegeResponse) collegeResponseTransformer.buildExceptionResponse(e, response);
		}
	}
}
