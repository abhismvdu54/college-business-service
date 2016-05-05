package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.CollegeDTO;
import com.cd.college.dto.response.CollegeProgramDTO;
import com.cd.college.dto.response.ProgramDTO;
import com.cd.college.entity.CollegeProgramEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeProgramResponse;

@Component
public class CollegeProgramResponseTransformer extends BaseResponseTransfomer{

	public CollegeProgramResponse transformIntoSuccessResponse(CollegeProgramResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public CollegeProgramResponse transformIntoCollegeProgramDTOList(List<CollegeProgramEntity> collegeProgramEntities)
	throws CollegeBusinessServiceException{
		CollegeProgramResponse response = new CollegeProgramResponse();
		List<CollegeProgramDTO> dtoList = new ArrayList<CollegeProgramDTO>();
		for(CollegeProgramEntity entity : collegeProgramEntities){
			CollegeProgramDTO dto = new CollegeProgramDTO();
			if(entity.getCollegeProgramId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"college Porgram id can't be null");
			}
			dto.setCollegeProgramId(entity.getCollegeProgramId());
			//populate college dto
			CollegeDTO collegeDTO = new CollegeDTO();
			collegeDTO.setCollegeId(entity.getCollegeId().getCollegeId());
			collegeDTO.setCollegeCode(entity.getCollegeId().getCollegeCode());
			collegeDTO.setCollegeDesc(entity.getCollegeId().getCollegeDesc());
			//populate program dto
			ProgramDTO programDTO = new ProgramDTO();
			programDTO.setProgramId(entity.getProgramId().getProgramId());
			programDTO.setProgramCode(entity.getProgramId().getProgramCode());
			programDTO.setProgramDesc(entity.getProgramId().getProgramDesc());
			
			dto.setCollege(collegeDTO);
			dto.setProgram(programDTO);
		
			dtoList.add(dto);
		}
		response.setCollegePrograms(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
