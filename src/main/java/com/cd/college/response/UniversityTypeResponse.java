package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.UniversityTypeDTO;

public class UniversityTypeResponse extends BaseResponse{
	private UniversityTypeDTO universityType;
	List<UniversityTypeDTO> universityTypes;
	
	public UniversityTypeDTO getUniversityType() {
		return universityType;
	}
	public void setUniversityType(UniversityTypeDTO universityType) {
		this.universityType = universityType;
	}
	public List<UniversityTypeDTO> getUniversityTypes() {
		return universityTypes;
	}
	public void setUniversityTypes(List<UniversityTypeDTO> universityTypes) {
		this.universityTypes = universityTypes;
	}
}
