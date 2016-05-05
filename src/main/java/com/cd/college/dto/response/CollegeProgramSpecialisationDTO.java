package com.cd.college.dto.response;

public class CollegeProgramSpecialisationDTO {
	private int collegeProgramSpecialisationId;
	private CollegeProgramDTO collegeProgram;
	private SpecialisationDTO specialisation;
	
	public int getCollegeProgramSpecialisationId() {
		return collegeProgramSpecialisationId;
	}
	public void setCollegeProgramSpecialisationId(int collegeProgramSpecialisationId) {
		this.collegeProgramSpecialisationId = collegeProgramSpecialisationId;
	}
	public CollegeProgramDTO getCollegeProgram() {
		return collegeProgram;
	}
	public void setCollegeProgram(CollegeProgramDTO collegeProgram) {
		this.collegeProgram = collegeProgram;
	}
	public SpecialisationDTO getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(SpecialisationDTO specialisation) {
		this.specialisation = specialisation;
	}
}
