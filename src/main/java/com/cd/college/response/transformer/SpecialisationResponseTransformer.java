package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.SpecialisationDTO;
import com.cd.college.entity.SpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.SpecialisationResponse;

@Component
public class SpecialisationResponseTransformer extends BaseResponseTransfomer{


	public SpecialisationResponse transformIntoSuccessResponse(SpecialisationResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public SpecialisationResponse transformIntoSpecialisationDTOList(List<SpecialisationEntity> specialisationEntities)
	throws CollegeBusinessServiceException{
		SpecialisationResponse response = new SpecialisationResponse();
		List<SpecialisationDTO> dtoList = new ArrayList<SpecialisationDTO>();
		for(SpecialisationEntity entity : specialisationEntities){
			SpecialisationDTO dto = new SpecialisationDTO();
			if(entity.getSpecialisationId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"specialisation id can't be null");
			}
			dto.setSpecialisationId(entity.getSpecialisationId());
			dto.setSpecialisationCode(entity.getSpecialisationCode());
			dto.setSpecialisationDesc(entity.getSpecialisationDesc());
			dtoList.add(dto);
		}
		response.setSpecialisations(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
