package com.cd.college.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "program_specialisation")
public class ProgramSpecialisationEntity{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_specialisation_id")
    private Integer programSpecialisationId;
	
	@ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    private ProgramEntity programId;
	
	@ManyToOne
    @JoinColumn(name = "specialisation_id", referencedColumnName = "specialisation_id", nullable = false)
    private SpecialisationEntity specialisationId;
	
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
	
	@OneToMany(mappedBy = "programSpecialisationId")
    private Set<ProgramSpecialisationSubjectEntity> programSpecialisationSubjects;
	
	public Integer getProgramSpecialisationId() {
		return programSpecialisationId;
	}

	public void setProgramSpecialisationId(Integer programSpecialisationId) {
		this.programSpecialisationId = programSpecialisationId;
	}

	public ProgramEntity getProgramId() {
		return programId;
	}

	public void setProgramId(ProgramEntity programId) {
		this.programId = programId;
	}

	public SpecialisationEntity getSpecialisationId() {
		return specialisationId;
	}

	public void setSpecialisationId(SpecialisationEntity specialisationId) {
		this.specialisationId = specialisationId;
	}

	public Set<ProgramSpecialisationSubjectEntity> getProgramSpecialisationSubjects() {
		return programSpecialisationSubjects;
	}

	public void setProgramSpecialisationSubjects(Set<ProgramSpecialisationSubjectEntity> programSpecialisationSubjects) {
		this.programSpecialisationSubjects = programSpecialisationSubjects;
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
