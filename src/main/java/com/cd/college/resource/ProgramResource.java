package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.ProgramService;
import com.cd.college.entity.ProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramResponse;
import com.cd.college.response.transformer.ProgramResponseTransformer;

@RestController
@RequestMapping(value = "/program")
public class ProgramResource {

	@Autowired
	private ProgramResponseTransformer programResponseTransformer;
	
	@Autowired
	private ProgramService programService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody ProgramResponse getPrograms() {
		ProgramResponse response = null;
		try {
			List<ProgramEntity> listOfEntities = programService.getPrograms();
			//transform the entities into the corresponding dto objects
			return programResponseTransformer.transformIntoProgramDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (ProgramResponse) programResponseTransformer.buildExceptionResponse(e, response);
		}
	}
	
}
