package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.CollegeDTO;
import com.cd.college.entity.CollegeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeResponse;

@Component
public class CollegeResponseTransformer extends BaseResponseTransfomer{

	public CollegeResponse transformIntoSuccessResponse(CollegeResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public CollegeResponse transformIntoCollegeDTOList(List<CollegeEntity> collegeEntities)
	throws CollegeBusinessServiceException{
		CollegeResponse response = new CollegeResponse();
		List<CollegeDTO> dtoList = new ArrayList<CollegeDTO>();
		for(CollegeEntity entity : collegeEntities){
			CollegeDTO dto = new CollegeDTO();
			if(entity.getCollegeId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"college id can't be null");
			}
			dto.setCollegeId(entity.getCollegeId());
			dto.setCollegeCode(entity.getCollegeCode());
			dto.setCollegeDesc(entity.getCollegeDesc());
			dto.setCollegeTypeId(entity.getCollegeTypeId().getCollegeTypeId());
			dto.setUniversityId(entity.getUniversityId().getUniversityId());
			dtoList.add(dto);
		}
		response.setColleges(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
