package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.DegreeDTO;
import com.cd.college.entity.DegreeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.DegreeResponse;

@Component
public class DegreeResponseTransformer extends BaseResponseTransfomer{

	public DegreeResponse transformIntoSuccessResponse(DegreeResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public DegreeResponse transformIntoDegreeDTOList(List<DegreeEntity> degreeEntities)
	throws CollegeBusinessServiceException{
		DegreeResponse response = new DegreeResponse();
		List<DegreeDTO> dtoList = new ArrayList<DegreeDTO>();
		for(DegreeEntity entity : degreeEntities){
			DegreeDTO dto = new DegreeDTO();
			if(entity.getDegreeId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Degree id can't be null");
			}
			dto.setDegreeId(entity.getDegreeId());
			dto.setDegreeCode(entity.getDegreeCode());
			dto.setDegreeDesc(entity.getDegreeDesc());
			dtoList.add(dto);
		}
		response.setDegrees(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
