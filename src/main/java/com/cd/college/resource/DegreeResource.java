package com.cd.college.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.college.business.service.DegreeService;
import com.cd.college.entity.DegreeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.DegreeResponse;
import com.cd.college.response.transformer.DegreeResponseTransformer;

@RestController
@RequestMapping(value = "/degree")
public class DegreeResource {

	@Autowired
	private DegreeResponseTransformer degreeResponseTransformer;
	
	@Autowired
	private DegreeService degreeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody DegreeResponse getDegrees() {
		DegreeResponse response = null;
		try {
			List<DegreeEntity> listOfEntities = degreeService.getDegrees();
			//transform the entities into the corresponding dto objects
			return degreeResponseTransformer.transformIntoDegreeDTOList(listOfEntities);
		} catch (CollegeBusinessServiceException e) {
			return (DegreeResponse) degreeResponseTransformer.buildExceptionResponse(e, response);
		}
	}
	
}
