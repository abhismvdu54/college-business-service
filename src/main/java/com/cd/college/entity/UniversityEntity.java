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
@Table(name = "university")
public class UniversityEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private Integer universityId;

	public Integer getUniversityId() {
        return this.universityId;
    }

	public void setUniversityId(Integer id) {
        this.universityId = id;
    }

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("colleges").toString();
    }

	@OneToMany(mappedBy = "universityId")
    private Set<CollegeEntity> colleges;

	@Column(name = "university_code", length = 20, unique = true)
    @NotNull
    private String universityCode;

	@Column(name = "university_type_id")
    @NotNull
    private Integer universityTypeId;

	@Column(name = "university_desc", length = 100)
    private String universityDesc;

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

	public Set<CollegeEntity> getColleges() {
        return colleges;
    }

	public void setColleges(Set<CollegeEntity> colleges) {
        this.colleges = colleges;
    }

	public String getUniversityCode() {
        return universityCode;
    }

	public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

	public Integer getUniversityTypeId() {
        return universityTypeId;
    }

	public void setUniversityTypeId(Integer universityTypeId) {
        this.universityTypeId = universityTypeId;
    }

	public String getUniversityDesc() {
        return universityDesc;
    }

	public void setUniversityDesc(String universityDesc) {
        this.universityDesc = universityDesc;
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
