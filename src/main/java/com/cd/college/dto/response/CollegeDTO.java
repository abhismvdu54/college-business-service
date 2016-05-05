package com.cd.college.dto.response;

public class CollegeDTO {

	private int collegeId;
	private String collegeCode;
	private int collegeTypeId;
	private int universityId;
	private String collegeDesc;
	
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeCode() {
		return collegeCode;
	}
	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	public int getCollegeTypeId() {
		return collegeTypeId;
	}
	public void setCollegeTypeId(int collegeTypeId) {
		this.collegeTypeId = collegeTypeId;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public String getCollegeDesc() {
		return collegeDesc;
	}
	public void setCollegeDesc(String collegeDesc) {
		this.collegeDesc = collegeDesc;
	}
}
