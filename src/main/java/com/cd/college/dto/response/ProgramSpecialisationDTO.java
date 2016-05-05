package com.cd.college.dto.response;

public class ProgramSpecialisationDTO {
	private int programSpecialisationId;
	private ProgramDTO program;
	private SpecialisationDTO specialisation;
	
	public int getProgramSpecialisationId() {
		return programSpecialisationId;
	}
	public void setProgramSpecialisationId(int programSpecialisationId) {
		this.programSpecialisationId = programSpecialisationId;
	}
	public ProgramDTO getProgram() {
		return program;
	}
	public void setProgram(ProgramDTO program) {
		this.program = program;
	}
	public SpecialisationDTO getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(SpecialisationDTO specialisation) {
		this.specialisation = specialisation;
	}
}
