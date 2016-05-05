package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.ProgramSpecialisationSubjectService;
import com.cd.college.entity.ProgramSpecialisationSubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramSpecialisationSubjectResponse;
import com.cd.college.response.transformer.ProgramSpecialisationSubjectResponseTransformer;

@RestController
@RequestMapping(value = "/program-specialisation-subject")
public class ProgramSpecialisationSubjectResource {

	@Autowired
	private ProgramSpecialisationSubjectResponseTransformer programSpecialisationSubjectResponseTransformer;
	
	@Autowired
	private ProgramSpecialisationSubjectService programSpecialisationSubjectService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody ProgramSpecialisationSubjectResponse getProgramSpecialisationSubjects() {
		ProgramSpecialisationSubjectResponse response = null;
		try {
			List<ProgramSpecialisationSubjectEntity> listOfEntities = programSpecialisationSubjectService.getProgramSpecialisationSubjects();
			//transform the entities into the corresponding dto objects
			return programSpecialisationSubjectResponseTransformer.transformIntoProgramSpecialisationSubjectDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (ProgramSpecialisationSubjectResponse) programSpecialisationSubjectResponseTransformer.buildExceptionResponse(e, response);
		}
	}

}
