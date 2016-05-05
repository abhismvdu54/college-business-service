package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.ProgramDTO;
import com.cd.college.dto.response.ProgramSpecialisationDTO;
import com.cd.college.dto.response.SpecialisationDTO;
import com.cd.college.entity.ProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramSpecialisationResponse;

@Component
public class ProgramSpecialisationResponseTransformer extends BaseResponseTransfomer{


	public ProgramSpecialisationResponse transformIntoSuccessResponse(ProgramSpecialisationResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public ProgramSpecialisationResponse transformIntoProgramSpecialisationDTOList(List<ProgramSpecialisationEntity> programSpecialisationEntities)
	throws CollegeBusinessServiceException{
		ProgramSpecialisationResponse response = new ProgramSpecialisationResponse();
		List<ProgramSpecialisationDTO> dtoList = new ArrayList<ProgramSpecialisationDTO>();
		for(ProgramSpecialisationEntity entity : programSpecialisationEntities){
			ProgramSpecialisationDTO dto = new ProgramSpecialisationDTO();
			if(entity.getProgramSpecialisationId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"Program specialisation id can't be null");
			}
			dto.setProgramSpecialisationId(entity.getProgramSpecialisationId());
			//set program
			ProgramDTO programDTO = new ProgramDTO();
			programDTO.setProgramId(entity.getProgramId().getProgramId());
			programDTO.setProgramCode(entity.getProgramId().getProgramCode());
			programDTO.setProgramDesc(entity.getProgramId().getProgramDesc());
			dto.setProgram(programDTO);
			//set specialisation
			SpecialisationDTO specialisationDTO = new SpecialisationDTO();
			specialisationDTO.setSpecialisationId(entity.getSpecialisationId().getSpecialisationId());
			specialisationDTO.setSpecialisationDesc(entity.getSpecialisationId().getSpecialisationDesc());
			specialisationDTO.setSpecialisationCode(entity.getSpecialisationId().getSpecialisationCode());
			dto.setSpecialisation(specialisationDTO);
			
			dtoList.add(dto);
		}
		response.setProgramSpecialisations(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
