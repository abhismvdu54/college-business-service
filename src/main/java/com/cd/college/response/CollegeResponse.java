package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.CollegeDTO;

public class CollegeResponse extends BaseResponse{

	private CollegeDTO college;
	private List<CollegeDTO> colleges;
	
	public CollegeDTO getCollege() {
		return college;
	}
	public void setCollege(CollegeDTO college) {
		this.college = college;
	}
	public List<CollegeDTO> getColleges() {
		return colleges;
	}
	public void setColleges(List<CollegeDTO> colleges) {
		this.colleges = colleges;
	}
}
