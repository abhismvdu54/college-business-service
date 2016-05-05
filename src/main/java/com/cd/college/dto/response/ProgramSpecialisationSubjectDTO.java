package com.cd.college.dto.response;

public class ProgramSpecialisationSubjectDTO {
	private int programSpecialisationSubjectId;
	private ProgramSpecialisationDTO programSpecialisation;
	private SubjectDTO subject;
	
	public int getProgramSpecialisationSubjectId() {
		return programSpecialisationSubjectId;
	}
	public void setProgramSpecialisationSubjectId(int programSpecialisationSubjectId) {
		this.programSpecialisationSubjectId = programSpecialisationSubjectId;
	}
	public ProgramSpecialisationDTO getProgramSpecialisation() {
		return programSpecialisation;
	}
	public void setProgramSpecialisation(ProgramSpecialisationDTO programSpecialisation) {
		this.programSpecialisation = programSpecialisation;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
}
