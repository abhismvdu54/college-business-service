package com.cd.college.dto.response;

public class CollegeProgramDTO {

	private int collegeProgramId;
	private CollegeDTO college;
	private ProgramDTO program;
	
	public int getCollegeProgramId() {
		return collegeProgramId;
	}
	public void setCollegeProgramId(int collegeProgramId) {
		this.collegeProgramId = collegeProgramId;
	}
	public CollegeDTO getCollege() {
		return college;
	}
	public void setCollege(CollegeDTO college) {
		this.college = college;
	}
	public ProgramDTO getProgram() {
		return program;
	}
	public void setProgram(ProgramDTO program) {
		this.program = program;
	}

}
