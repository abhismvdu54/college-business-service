package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.DegreeDTO;

public class DegreeResponse extends BaseResponse{
	private DegreeDTO degree;
	private List<DegreeDTO> degrees;
	
	public DegreeDTO getDegree() {
		return degree;
	}
	public void setDegree(DegreeDTO degree) {
		this.degree = degree;
	}
	public List<DegreeDTO> getDegrees() {
		return degrees;
	}
	public void setDegrees(List<DegreeDTO> degrees) {
		this.degrees = degrees;
	}
}
