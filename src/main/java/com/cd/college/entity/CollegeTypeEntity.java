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
@Table(name = "college_type")
public class CollegeTypeEntity {

	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("colleges").toString();
    }

	@OneToMany(mappedBy = "collegeTypeId")
    private Set<CollegeEntity> colleges;

	@Column(name = "college_type_code", length = 20, unique = true)
    private String collegeTypeCode;

	@Column(name = "college_type_desc", length = 100)
    private String collegeTypeDesc;

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

	public String getCollegeTypeCode() {
        return collegeTypeCode;
    }

	public void setCollegeTypeCode(String collegeTypeCode) {
        this.collegeTypeCode = collegeTypeCode;
    }

	public String getCollegeTypeDesc() {
        return collegeTypeDesc;
    }

	public void setCollegeTypeDesc(String collegeTypeDesc) {
        this.collegeTypeDesc = collegeTypeDesc;
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

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_type_id")
    private Integer collegeTypeId;

	public Integer getCollegeTypeId() {
        return this.collegeTypeId;
    }

	public void setCollegeTypeId(Integer id) {
        this.collegeTypeId = id;
    }
}
