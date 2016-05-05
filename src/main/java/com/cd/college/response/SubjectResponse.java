package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.SubjectDTO;

public class SubjectResponse extends BaseResponse{

	private SubjectDTO subject;
	private List<SubjectDTO> subjects;
	
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public List<SubjectDTO> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}
	
}
