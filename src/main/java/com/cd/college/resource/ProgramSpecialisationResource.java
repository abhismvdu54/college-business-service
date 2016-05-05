package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.ProgramSpecialisationService;
import com.cd.college.entity.ProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramSpecialisationResponse;
import com.cd.college.response.transformer.ProgramSpecialisationResponseTransformer;

@RestController
@RequestMapping(value = "/program-specialisation")
public class ProgramSpecialisationResource {

	@Autowired
	private ProgramSpecialisationResponseTransformer programSpecialisationResponseTransformer;
	
	@Autowired
	private ProgramSpecialisationService programSpecialisationService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody ProgramSpecialisationResponse getProgramSpecialisations() {
		ProgramSpecialisationResponse response = null;
		try {
			List<ProgramSpecialisationEntity> listOfEntities = programSpecialisationService.getProgramSpecialisations();
			//transform the entities into the corresponding dto objects
			return programSpecialisationResponseTransformer.transformIntoProgramSpecialisationDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (ProgramSpecialisationResponse) programSpecialisationResponseTransformer.buildExceptionResponse(e, response);
		}
	}
}
