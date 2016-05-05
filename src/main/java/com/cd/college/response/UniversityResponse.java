package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.UniversityDTO;

public class UniversityResponse extends BaseResponse{

	private UniversityDTO university;
	private List<UniversityDTO> universities;
	
	public UniversityDTO getUniversity() {
		return university;
	}
	public void setUniversity(UniversityDTO university) {
		this.university = university;
	}
	public List<UniversityDTO> getUniversities() {
		return universities;
	}
	public void setUniversities(List<UniversityDTO> universities) {
		this.universities = universities;
	}
}
