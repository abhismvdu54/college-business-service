package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.UniversityTypeDTO;
import com.cd.college.entity.UniversityTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.UniversityTypeResponse;

@Component
public class UniversityTypeResponseTransformer extends BaseResponseTransfomer{

	public UniversityTypeResponse transformIntoSuccessResponse(UniversityTypeResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public UniversityTypeResponse transformIntoUniversityTypeDTOList(List<UniversityTypeEntity> universityTypeEntities)
	throws CollegeBusinessServiceException{
		UniversityTypeResponse response = new UniversityTypeResponse();
		List<UniversityTypeDTO> dtoList = new ArrayList<UniversityTypeDTO>();
		for(UniversityTypeEntity cte : universityTypeEntities){
			UniversityTypeDTO dto = new UniversityTypeDTO();
			if(cte.getUniversityTypeId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"University Type id can't be null");
			}
			dto.setUniversityTypeId(cte.getUniversityTypeId());
			dto.setUniversityTypeCode(cte.getUniversityTypeCode());
			dto.setUniversityTypeDesc(cte.getUniverstiyTypeDesc());
			dtoList.add(dto);
		}
		response.setUniversityTypes(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
