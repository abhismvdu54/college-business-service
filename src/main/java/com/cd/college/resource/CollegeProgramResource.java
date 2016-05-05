package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.CollegeProgramService;
import com.cd.college.entity.CollegeProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeProgramResponse;
import com.cd.college.response.transformer.CollegeProgramResponseTransformer;

@RestController
@RequestMapping(value = "/college-program")
public class CollegeProgramResource {

	@Autowired
	private CollegeProgramResponseTransformer collegeProgramResponseTransformer;
	
	@Autowired
	private CollegeProgramService collegeProgramService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody CollegeProgramResponse getCollegePrograms() {
		CollegeProgramResponse response = null;
		try {
			List<CollegeProgramEntity> listOfEntities = collegeProgramService.getCollegePrograms();
			//transform the entities into the corresponding dto objects
			return collegeProgramResponseTransformer.transformIntoCollegeProgramDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (CollegeProgramResponse) collegeProgramResponseTransformer.buildExceptionResponse(e, response);
		}
	}
	
}
