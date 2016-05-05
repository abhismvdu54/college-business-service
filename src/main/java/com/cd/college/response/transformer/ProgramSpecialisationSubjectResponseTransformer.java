package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.ProgramDTO;
import com.cd.college.dto.response.ProgramSpecialisationDTO;
import com.cd.college.dto.response.ProgramSpecialisationSubjectDTO;
import com.cd.college.dto.response.SpecialisationDTO;
import com.cd.college.dto.response.SubjectDTO;
import com.cd.college.entity.ProgramSpecialisationSubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.ProgramSpecialisationSubjectResponse;

@Component
public class ProgramSpecialisationSubjectResponseTransformer extends BaseResponseTransfomer{

	public ProgramSpecialisationSubjectResponse transformIntoSuccessResponse(ProgramSpecialisationSubjectResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public ProgramSpecialisationSubjectResponse transformIntoProgramSpecialisationSubjectDTOList(List<ProgramSpecialisationSubjectEntity> entities)
	throws CollegeBusinessServiceException{
		ProgramSpecialisationSubjectResponse response = new ProgramSpecialisationSubjectResponse();
		List<ProgramSpecialisationSubjectDTO> dtoList = new ArrayList<ProgramSpecialisationSubjectDTO>();
		for(ProgramSpecialisationSubjectEntity entity : entities){
			ProgramSpecialisationSubjectDTO dto = new ProgramSpecialisationSubjectDTO();
			if(entity.getProgramSpecialisationSubjectId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"college id can't be null");
			}
			dto.setProgramSpecialisationSubjectId(entity.getProgramSpecialisationSubjectId());
			
			//set Program Specialisation
			ProgramSpecialisationDTO programSpecialisationDTO = new ProgramSpecialisationDTO();
			programSpecialisationDTO.setProgramSpecialisationId(entity.getProgramSpecialisationId().getProgramSpecialisationId());
			
			ProgramDTO programDTO = new ProgramDTO();
			programDTO.setProgramId(entity.getProgramSpecialisationId().getProgramId().getProgramId());
			programSpecialisationDTO.setProgram(programDTO);
			
			//set specialisation
			SpecialisationDTO specialDTO = new SpecialisationDTO();
			specialDTO.setSpecialisationId(entity.getProgramSpecialisationId().getSpecialisationId().getSpecialisationId());
			specialDTO.setSpecialisationCode(entity.getProgramSpecialisationId().getSpecialisationId().getSpecialisationCode());
			specialDTO.setSpecialisationDesc(entity.getProgramSpecialisationId().getSpecialisationId().getSpecialisationDesc());
			
			programSpecialisationDTO.setSpecialisation(specialDTO);
			
			dto.setProgramSpecialisation(programSpecialisationDTO);
			//set subject
			SubjectDTO subjectDTO = new SubjectDTO();
			subjectDTO.setSubjectId(entity.getSubjectId().getSubjectId());
			subjectDTO.setSubjectCode(entity.getSubjectId().getSubjectCode());
			subjectDTO.setSubjectDesc(entity.getSubjectId().getSubjectDesc());
			dto.setSubject(subjectDTO);
			
			dtoList.add(dto);
		}
		response.setProgramSpecialisationSubjects(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
