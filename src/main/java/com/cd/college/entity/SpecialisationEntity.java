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
@Table(name = "specialisation")
public class SpecialisationEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specialisation_id")
    private Integer specialisationId;

	public Integer getSpecialisationId() {
        return this.specialisationId;
    }

	public void setSpecialisationId(Integer id) {
        this.specialisationId = id;
    }

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("collegeProgramSpecialisations", "subjects").toString();
    }

	@OneToMany(mappedBy = "specialisationId")
    private Set<ProgramSpecialisationEntity> programSpecialisations;

	@OneToMany(mappedBy = "specialisationId")
    private Set<CollegeProgramSpecialisationEntity> collegeProgramSpecialisations;

	@Column(name = "specialisation_code", length = 5, unique = true)
    @NotNull
    private String specialisationCode;

	@Column(name = "specialisation_desc", length = 100)
    @NotNull
    private String specialisationDesc;

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

	public Set<CollegeProgramSpecialisationEntity> getCollegeProgramSpecialisations() {
        return collegeProgramSpecialisations;
    }

	public void setCollegeProgramSpecialisations(Set<CollegeProgramSpecialisationEntity> collegeProgramSpecialisations) {
        this.collegeProgramSpecialisations = collegeProgramSpecialisations;
    }

	public String getSpecialisationCode() {
        return specialisationCode;
    }

	public void setSpecialisationCode(String specialisationCode) {
        this.specialisationCode = specialisationCode;
    }

	public String getSpecialisationDesc() {
        return specialisationDesc;
    }

	public void setSpecialisationDesc(String specialisationDesc) {
        this.specialisationDesc = specialisationDesc;
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
