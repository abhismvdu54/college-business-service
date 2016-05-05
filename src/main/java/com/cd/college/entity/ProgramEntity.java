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

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "program")
public class ProgramEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_id")
    private Integer programId;

	public Integer getProgramId() {
        return this.programId;
    }

	public void setProgramId(Integer id) {
        this.programId = id;
    }

	@OneToMany(mappedBy = "programId")
    private Set<ProgramSpecialisationEntity> programSpecialisations;
	
	@OneToMany(mappedBy = "programId")
    private Set<CollegeProgramEntity> collegePrograms;

	@ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id", nullable = false)
    private DegreeEntity degreeId;

	@Column(name = "program_code", length = 20, unique = true)
    @NotNull
    private String programCode;

	@Column(name = "program_desc", length = 100)
    @NotNull
    private String programDesc;

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

	public Set<CollegeProgramEntity> getCollegePrograms() {
        return collegePrograms;
    }

	public void setCollegePrograms(Set<CollegeProgramEntity> collegePrograms) {
        this.collegePrograms = collegePrograms;
    }

	public DegreeEntity getDegreeId() {
        return degreeId;
    }

	public void setDegreeId(DegreeEntity degreeId) {
        this.degreeId = degreeId;
    }

	public String getProgramCode() {
        return programCode;
    }

	public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

	public String getProgramDesc() {
        return programDesc;
    }

	public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
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

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("collegePrograms", "degreeId").toString();
    }
}
