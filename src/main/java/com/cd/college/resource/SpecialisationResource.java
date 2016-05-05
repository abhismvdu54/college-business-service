package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.SpecialisationService;
import com.cd.college.entity.SpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.SpecialisationResponse;
import com.cd.college.response.transformer.SpecialisationResponseTransformer;

@RestController
@RequestMapping(value = "/specialisation")
public class SpecialisationResource {

	@Autowired
	private SpecialisationResponseTransformer specialisationResponseTransformer;
	
	@Autowired
	private SpecialisationService specialisationService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody SpecialisationResponse getSpecialisations() {
		SpecialisationResponse response = null;
		try {
			List<SpecialisationEntity> listOfEntities = specialisationService.getSpecialisations();
			//transform the entities into the corresponding dto objects
			return specialisationResponseTransformer.transformIntoSpecialisationDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (SpecialisationResponse) specialisationResponseTransformer.buildExceptionResponse(e, response);
		}
	}
}
