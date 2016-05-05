package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.CollegeProgramSpecialisationService;
import com.cd.college.entity.CollegeProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeProgramSpecialisationResponse;
import com.cd.college.response.CollegeResponse;
import com.cd.college.response.transformer.CollegeProgramSpecialisationResponseTransformer;

@RestController
@RequestMapping(value = "/college-program-specialisation")
public class CollegeProgramSpecialisationResource {


	@Autowired
	private CollegeProgramSpecialisationResponseTransformer collegeProgramSpecialisationResponseTransformer;
	
	@Autowired
	private CollegeProgramSpecialisationService collegeProgramSpecialisationService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody CollegeProgramSpecialisationResponse getCollegeProgramSpecialisations() {
		CollegeResponse response = null;
		try {
			List<CollegeProgramSpecialisationEntity> listOfEntities = collegeProgramSpecialisationService.getCollegeProgramSpecialisations();
			//transform the entities into the corresponding dto objects
			return collegeProgramSpecialisationResponseTransformer.transformIntoCollegeProgramSpecialisationDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (CollegeProgramSpecialisationResponse) collegeProgramSpecialisationResponseTransformer.
					buildExceptionResponse(e, response);
		}
	}
}
