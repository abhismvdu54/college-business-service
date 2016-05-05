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
@Table(name = "college")
public class CollegeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id")
    private Integer collegeId;

	public Integer getCollegeId() {
        return this.collegeId;
    }

	public void setCollegeId(Integer id) {
        this.collegeId = id;
    }

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("collegePrograms", "collegeTypeId", "universityId").toString();
    }

	@OneToMany(mappedBy = "collegeId")
    private Set<CollegeProgramEntity> collegePrograms;

	@ManyToOne
    @JoinColumn(name = "college_type_id", referencedColumnName = "college_type_id", nullable = false)
    private CollegeTypeEntity collegeTypeId;

	@ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "university_id", nullable = false)
    private UniversityEntity universityId;

	@Column(name = "college_code", length = 20, unique = true)
    private String collegeCode;

	@Column(name = "college_desc", length = 100)
    private String collegeDesc;

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

	public CollegeTypeEntity getCollegeTypeId() {
        return collegeTypeId;
    }

	public void setCollegeTypeId(CollegeTypeEntity collegeTypeId) {
        this.collegeTypeId = collegeTypeId;
    }

	public UniversityEntity getUniversityId() {
        return universityId;
    }

	public void setUniversityId(UniversityEntity universityId) {
        this.universityId = universityId;
    }

	public String getCollegeCode() {
        return collegeCode;
    }

	public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

	public String getCollegeDesc() {
        return collegeDesc;
    }

	public void setCollegeDesc(String collegeDesc) {
        this.collegeDesc = collegeDesc;
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
