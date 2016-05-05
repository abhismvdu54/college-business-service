package com.cd.college.response.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cd.college.business.constant.CommonConstants;
import com.cd.college.dto.response.SubjectDTO;
import com.cd.college.entity.SubjectEntity;
import com.cd.college.exception.CollegeBusinessServiceException;
import com.cd.college.response.SubjectResponse;

@Component
public class SubjectResponseTransformer extends BaseResponseTransfomer{

	public SubjectResponse transformIntoSuccessResponse(SubjectResponse response){
		super.buildSuccessMessage(response);
		return response;
	}

	public SubjectResponse transformIntoSubjectDTOList(List<SubjectEntity> subjectEntities)
	throws CollegeBusinessServiceException{
		SubjectResponse response = new SubjectResponse();
		List<SubjectDTO> dtoList = new ArrayList<SubjectDTO>();
		for(SubjectEntity entity : subjectEntities){
			SubjectDTO dto = new SubjectDTO();
			if(entity.getSubjectId() == null){
				throw new CollegeBusinessServiceException(CommonConstants.APPLICATION_CODE_COLLEGE_SERVICE, 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						"subject id can't be null");
			}
			dto.setSubjectId(entity.getSubjectId());
			dto.setSubjectCode(entity.getSubjectCode());
			dto.setSubjectDesc(entity.getSubjectDesc());
			dtoList.add(dto);
		}
		response.setSubjects(dtoList);
		transformIntoSuccessResponse(response);
		return response;
	}
	
	@Override
	protected int getApplicationCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
