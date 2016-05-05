package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.SpecialisationDTO;

public class SpecialisationResponse extends BaseResponse{
	private SpecialisationDTO specialisation;
	private List<SpecialisationDTO> specialisations;
	
	public SpecialisationDTO getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(SpecialisationDTO specialisation) {
		this.specialisation = specialisation;
	}
	public List<SpecialisationDTO> getSpecialisations() {
		return specialisations;
	}
	public void setSpecialisations(List<SpecialisationDTO> specialisations) {
		this.specialisations = specialisations;
	}
}
