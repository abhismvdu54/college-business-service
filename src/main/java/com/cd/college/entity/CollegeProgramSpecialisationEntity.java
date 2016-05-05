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
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "college_program_specialisation")
public class CollegeProgramSpecialisationEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_program_specialisation_id")
    private Integer collegeProgramSpecialisationId;
	
	@ManyToOne
    @JoinColumn(name = "college_program_id", referencedColumnName = "college_program_id", nullable = false)
    private CollegeProgramEntity collegeProgramId;

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

	public CollegeProgramEntity getCollegeProgramId() {
        return collegeProgramId;
    }

	public void setCollegeProgramId(CollegeProgramEntity collegeProgramId) {
        this.collegeProgramId = collegeProgramId;
    }

	public SpecialisationEntity getSpecialisationId() {
        return specialisationId;
    }

	public void setSpecialisationId(SpecialisationEntity specialisationId) {
        this.specialisationId = specialisationId;
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

	public Integer getCollegeProgramSpecialisationId() {
        return this.collegeProgramSpecialisationId;
    }

	public void setCollegeProgramSpecialisationId(Integer id) {
        this.collegeProgramSpecialisationId = id;
    }

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("collegeProgramId", "specialisationId").toString();
    }
}
