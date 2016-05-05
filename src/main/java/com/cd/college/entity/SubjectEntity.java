package com.cd.college.entity;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "subject")
public class SubjectEntity {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("specialisationId").toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Integer subjectId;

	public Integer getSubjectId() {
        return this.subjectId;
    }

	public void setSubjectId(Integer id) {
        this.subjectId = id;
    }

	@OneToMany(mappedBy = "subjectId")
    private Set<ProgramSpecialisationSubjectEntity> programSpecialisationSubjects;
	
	@Column(name = "subject_code", length = 5, unique = true)
    private String subjectCode;

	@Column(name = "subject_desc", length = 100)
    private String subjectDesc;

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

	public String getSubjectCode() {
        return subjectCode;
    }

	public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

	public String getSubjectDesc() {
        return subjectDesc;
    }

	public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
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

	public Set<ProgramSpecialisationSubjectEntity> getProgramSpecialisationSubjects() {
		return programSpecialisationSubjects;
	}

	public void setProgramSpecialisationSubjects(Set<ProgramSpecialisationSubjectEntity> programSpecialisationSubjects) {
		this.programSpecialisationSubjects = programSpecialisationSubjects;
	}
}
