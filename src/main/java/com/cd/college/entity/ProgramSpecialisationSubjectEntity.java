package com.cd.college.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "program_specialisation_subject")
public class ProgramSpecialisationSubjectEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_specialisation_subject_id")
    private Integer programSpecialisationSubjectId;	
	
	@ManyToOne
    @JoinColumn(name = "program_specialisation_id", referencedColumnName = "program_specialisation_id", nullable = false)
	private ProgramSpecialisationEntity programSpecialisationId;
	
	@ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
	private SubjectEntity subjectId;

	@Column(name = "created_by", length = 100)
    @NotNull
    private String createdBy;

	@Column(name = "created_on")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Calendar createdOn;

	@Column(name = "last_updated_by", length = 100)
    @NotNull
    private String lastUpdatedBy;

	@Column(name = "last_updated_on")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Calendar lastUpdatedOn;
	public Integer getProgramSpecialisationSubjectId() {
		return programSpecialisationSubjectId;
	}

	public void setProgramSpecialisationSubjectId(Integer programSpecialisationSubjectId) {
		this.programSpecialisationSubjectId = programSpecialisationSubjectId;
	}

	public ProgramSpecialisationEntity getProgramSpecialisationId() {
		return programSpecialisationId;
	}

	public void setProgramSpecialisationId(ProgramSpecialisationEntity programSpecialisationId) {
		this.programSpecialisationId = programSpecialisationId;
	}

	public SubjectEntity getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(SubjectEntity subjectId) {
		this.subjectId = subjectId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Calendar getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Calendar lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
