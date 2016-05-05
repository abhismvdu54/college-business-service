package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.UniversityDTO;
import com.cd.college.entity.UniversityEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.UniversityResponse;

@Component
public class UniversityResponseTransformer extends BaseResponseTransfomer{
	
	public UniversityResponse transformIntoSuccessResponse(UniversityResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public UniversityResponse transformIntoCollegeTypeDTOList(List<UniversityEntity> universityEntities)
	throws CollegeBusinessServiceException{
		UniversityResponse response = new UniversityResponse();
		List<UniversityDTO> dtoList = new ArrayList<UniversityDTO>();
		for(UniversityEntity entity : universityEntities){
			UniversityDTO dto = new UniversityDTO();
			if(entity.getUniversityId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"CollegeResponse Type id can't be null");
			}
			dto.setUniversityId(entity.getUniversityId());
			dto.setUniversityCode(entity.getUniversityCode());
			dto.setUniversityDesc(entity.getUniversityDesc());
			dtoList.add(dto);
		}
		response.setUniversities(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
