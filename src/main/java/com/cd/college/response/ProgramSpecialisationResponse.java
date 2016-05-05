package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.ProgramSpecialisationDTO;

public class ProgramSpecialisationResponse extends BaseResponse{
	private ProgramSpecialisationDTO programSpecialisation;
	private List<ProgramSpecialisationDTO> programSpecialisations;
	
	public ProgramSpecialisationDTO getProgramSpecialisation() {
		return programSpecialisation;
	}
	public void setProgramSpecialisation(ProgramSpecialisationDTO programSpecialisation) {
		this.programSpecialisation = programSpecialisation;
	}
	public List<ProgramSpecialisationDTO> getProgramSpecialisations() {
		return programSpecialisations;
	}
	public void setProgramSpecialisations(List<ProgramSpecialisationDTO> programSpecialisations) {
		this.programSpecialisations = programSpecialisations;
	}

}
