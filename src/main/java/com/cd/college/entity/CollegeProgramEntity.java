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
@Table(name = "college_program")
public class CollegeProgramEntity {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("collegeProgramSpecialisations", "collegeId", "programId").toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_program_id")
    private Integer collegeProgramId;

	public Integer getCollegeProgramId() {
        return this.collegeProgramId;
    }

	public void setCollegeProgramId(Integer id) {
        this.collegeProgramId = id;
    }

	@OneToMany(mappedBy = "collegeProgramId")
    private Set<CollegeProgramSpecialisationEntity> collegeProgramSpecialisations;

	@ManyToOne
    @JoinColumn(name = "college_id", referencedColumnName = "college_id", nullable = false)
    private CollegeEntity collegeId;

	@ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    private ProgramEntity programId;

	@Column(name = "program_desc", length = 100)
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

	public Set<CollegeProgramSpecialisationEntity> getCollegeProgramSpecialisations() {
        return collegeProgramSpecialisations;
    }

	public void setCollegeProgramSpecialisations(Set<CollegeProgramSpecialisationEntity> collegeProgramSpecialisations) {
        this.collegeProgramSpecialisations = collegeProgramSpecialisations;
    }

	public CollegeEntity getCollegeId() {
        return collegeId;
    }

	public void setCollegeId(CollegeEntity collegeId) {
        this.collegeId = collegeId;
    }

	public ProgramEntity getProgramId() {
        return programId;
    }

	public void setProgramId(ProgramEntity programId) {
        this.programId = programId;
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
}
