package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.CollegeDTO;
import com.cd.college.dto.response.CollegeProgramDTO;
import com.cd.college.dto.response.CollegeProgramSpecialisationDTO;
import com.cd.college.dto.response.ProgramDTO;
import com.cd.college.dto.response.SpecialisationDTO;
import com.cd.college.entity.CollegeProgramSpecialisationEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.CollegeProgramSpecialisationResponse;

@Component
public class CollegeProgramSpecialisationResponseTransformer extends BaseResponseTransfomer{


	public CollegeProgramSpecialisationResponse transformIntoSuccessResponse(CollegeProgramSpecialisationResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public CollegeProgramSpecialisationResponse transformIntoCollegeProgramSpecialisationDTOList(List<CollegeProgramSpecialisationEntity> collegeProgramSpecialisationEntities)
	throws CollegeBusinessServiceException{
		CollegeProgramSpecialisationResponse response = new CollegeProgramSpecialisationResponse();
		List<CollegeProgramSpecialisationDTO> dtoList = new ArrayList<CollegeProgramSpecialisationDTO>();
		for(CollegeProgramSpecialisationEntity entity : collegeProgramSpecialisationEntities){
			CollegeProgramSpecialisationDTO dto = new CollegeProgramSpecialisationDTO();
			if(entity.getCollegeProgramSpecialisationId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"college program specialisation id can't be null");
			}
			dto.setCollegeProgramSpecialisationId(entity.getCollegeProgramSpecialisationId());
			//set college program
			CollegeProgramDTO collegeProgramDTO = new CollegeProgramDTO();
			
			CollegeDTO collegeDTO = new CollegeDTO();
			ProgramDTO programDTO = new ProgramDTO();
			collegeDTO.setCollegeId(entity.getCollegeProgramId().getCollegeId().getCollegeId());
			collegeDTO.setCollegeCode(entity.getCollegeProgramId().getCollegeId().getCollegeCode());
			collegeDTO.setCollegeDesc(entity.getCollegeProgramId().getCollegeId().getCollegeDesc());
			
			programDTO.setProgramId(entity.getCollegeProgramId().getProgramId().getProgramId());
			programDTO.setProgramCode(entity.getCollegeProgramId().getProgramId().getProgramCode());
			programDTO.setProgramDesc(entity.getCollegeProgramId().getProgramId().getProgramDesc());
			
			collegeProgramDTO.setCollegeProgramId(entity.getCollegeProgramId().getCollegeProgramId());
			collegeProgramDTO.setCollege(collegeDTO);
			collegeProgramDTO.setProgram(programDTO);
			
			dto.setCollegeProgram(collegeProgramDTO);
			//set specialisation
			SpecialisationDTO specialisationDTO = new SpecialisationDTO();
			specialisationDTO.setSpecialisationId(entity.getSpecialisationId().getSpecialisationId());
			specialisationDTO.setSpecialisationCode(entity.getSpecialisationId().getSpecialisationCode());
			specialisationDTO.setSpecialisationDesc(entity.getSpecialisationId().getSpecialisationDesc());
			dto.setSpecialisation(specialisationDTO);
			//add into list
			dtoList.add(dto);
		}
		response.setCollegeProgramSpecialisations(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
