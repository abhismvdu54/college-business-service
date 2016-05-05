package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.CollegeProgramSpecialisationDTO;

public class CollegeProgramSpecialisationResponse extends BaseResponse{
	private CollegeProgramSpecialisationDTO collegeProgramSpecialisation;
	private List<CollegeProgramSpecialisationDTO> collegeProgramSpecialisations;
	
	public CollegeProgramSpecialisationDTO getCollegeProgramSpecialisation() {
		return collegeProgramSpecialisation;
	}
	public void setCollegeProgramSpecialisation(CollegeProgramSpecialisationDTO collegeProgramSpecialisation) {
		this.collegeProgramSpecialisation = collegeProgramSpecialisation;
	}
	public List<CollegeProgramSpecialisationDTO> getCollegeProgramSpecialisations() {
		return collegeProgramSpecialisations;
	}
	public void setCollegeProgramSpecialisations(List<CollegeProgramSpecialisationDTO> collegeProgramSpecialisations) {
		this.collegeProgramSpecialisations = collegeProgramSpecialisations;
	}
	
}
