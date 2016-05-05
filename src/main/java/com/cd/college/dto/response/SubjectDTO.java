package com.cd.college.dto.response;

public class SubjectDTO {
	private int subjectId;
	private String subjectCode;
	private int specialisationId;
	private String subjectDesc;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public int getSpecialisationId() {
		return specialisationId;
	}
	public void setSpecialisationId(int specialisationId) {
		this.specialisationId = specialisationId;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

}
