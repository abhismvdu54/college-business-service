package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.CollegeTypeDTO;
import com.cd.college.entity.CollegeTypeEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeTypeResponse;

@Component
public class CollegeTypeResponseTransformer extends BaseResponseTransfomer{

	public CollegeTypeResponse transformIntoSuccessResponse(CollegeTypeResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public CollegeTypeResponse transformIntoCollegeTypeDTOList(List<CollegeTypeEntity> collegeTypeEntities)
	throws CollegeBusinessServiceException{
		CollegeTypeResponse response = new CollegeTypeResponse();
		List<CollegeTypeDTO> dtoList = new ArrayList<CollegeTypeDTO>();
		for(CollegeTypeEntity cte : collegeTypeEntities){
			CollegeTypeDTO dto = new CollegeTypeDTO();
			if(cte.getCollegeTypeId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"CollegeResponse Type id can't be null");
			}
			dto.setCollegeTypeId(cte.getCollegeTypeId());
			dto.setCollegeTypeCode(cte.getCollegeTypeCode());
			dto.setCollegeTypeDesc(cte.getCollegeTypeDesc());
			dtoList.add(dto);
		}
		response.setCollegeTypes(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
