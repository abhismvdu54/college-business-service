package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.CollegeTypeDTO;

public class CollegeTypeResponse extends BaseResponse{
	private CollegeTypeDTO collegeType;
	List<CollegeTypeDTO> collegeTypes;
	
	public CollegeTypeDTO getCollegeType() {
		return collegeType;
	}
	public void setCollegeType(CollegeTypeDTO collegeType) {
		this.collegeType = collegeType;
	}
	public List<CollegeTypeDTO> getCollegeTypes() {
		return collegeTypes;
	}
	public void setCollegeTypes(List<CollegeTypeDTO> collegeTypes) {
		this.collegeTypes = collegeTypes;
	}
}
