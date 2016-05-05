package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.ProgramDTO;
import com.cd.college.entity.ProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramResponse;

@Component
public class ProgramResponseTransformer extends BaseResponseTransfomer{

	public ProgramResponse transformIntoSuccessResponse(ProgramResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public ProgramResponse transformIntoProgramDTOList(List<ProgramEntity> programEntities)
	throws CollegeBusinessServiceException{
		ProgramResponse response = new ProgramResponse();
		List<ProgramDTO> dtoList = new ArrayList<ProgramDTO>();
		for(ProgramEntity entity : programEntities){
			ProgramDTO dto = new ProgramDTO();
			if(entity.getProgramId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Program id can't be null");
			}
			dto.setDegreeId(entity.getDegreeId().getDegreeId());
			dto.setProgramCode(entity.getProgramCode());
			dto.setProgramDesc(entity.getProgramDesc());
			dto.setProgramId(entity.getProgramId());
			dtoList.add(dto);
		}
		response.setPrograms(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
