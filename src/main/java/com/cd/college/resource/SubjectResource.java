package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.SubjectService;
import com.cd.college.entity.SubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.SubjectResponse;
import com.cd.college.response.transformer.SubjectResponseTransformer;

@RestController
@RequestMapping(value = "/subject")
public class SubjectResource {

	@Autowired
	private SubjectResponseTransformer subjectResponseTransformer;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody SubjectResponse getSubjects() {
		SubjectResponse response = null;
		try {
			List<SubjectEntity> listOfEntities = subjectService.getSubjects();
			//transform the entities into the corresponding dto objects
			return subjectResponseTransformer.transformIntoSubjectDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (SubjectResponse) subjectResponseTransformer.buildExceptionResponse(e, response);
		}
	}
}
