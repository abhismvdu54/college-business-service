package com.cd.college.response;

import java.util.List;

import com.cd.college.dto.response.ProgramDTO;

public class ProgramResponse extends BaseResponse{
	private ProgramDTO program;
	private List<ProgramDTO> programs;
	
	public ProgramDTO getProgram() {
		return program;
	}
	public void setProgram(ProgramDTO program) {
		this.program = program;
	}
	public List<ProgramDTO> getPrograms() {
		return programs;
	}
	public void setPrograms(List<ProgramDTO> programs) {
		this.programs = programs;
	}
}
