package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.ProgramSpecialisationSubjectDTO;

public class ProgramSpecialisationSubjectResponse extends BaseResponse{
	private ProgramSpecialisationSubjectDTO programSpecialisationSubject;
	private List<ProgramSpecialisationSubjectDTO> programSpecialisationSubjects;
	
	public ProgramSpecialisationSubjectDTO getProgramSpecialisationSubject() {
		return programSpecialisationSubject;
	}
	public void setProgramSpecialisationSubject(ProgramSpecialisationSubjectDTO programSpecialisationSubject) {
		this.programSpecialisationSubject = programSpecialisationSubject;
	}
	public List<ProgramSpecialisationSubjectDTO> getProgramSpecialisationSubjects() {
		return programSpecialisationSubjects;
	}
	public void setProgramSpecialisationSubjects(List<ProgramSpecialisationSubjectDTO> programSpecialisationSubjects) {
		this.programSpecialisationSubjects = programSpecialisationSubjects;
	}

}
