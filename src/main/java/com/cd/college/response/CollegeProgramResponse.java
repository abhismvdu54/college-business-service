package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.CollegeProgramDTO;

public class CollegeProgramResponse extends BaseResponse{
	private CollegeProgramDTO collegeProgram;
	private List<CollegeProgramDTO> collegePrograms;
	
	public CollegeProgramDTO getCollegeProgram() {
		return collegeProgram;
	}
	public void setCollegeProgram(CollegeProgramDTO collegeProgram) {
		this.collegeProgram = collegeProgram;
	}
	public List<CollegeProgramDTO> getCollegePrograms() {
		return collegePrograms;
	}
	public void setCollegePrograms(List<CollegeProgramDTO> collegePrograms) {
		this.collegePrograms = collegePrograms;
	}
}
