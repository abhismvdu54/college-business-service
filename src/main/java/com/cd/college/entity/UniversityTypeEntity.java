package com.cd.college.entity;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "university_type")
public class UniversityTypeEntity {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Column(name = "university_type_code", length = 20, unique = true)
    private String universityTypeCode;

	@Column(name = "universtiy_type_desc", length = 100)
    private String universtiyTypeDesc;

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

	public String getUniversityTypeCode() {
        return universityTypeCode;
    }

	public void setUniversityTypeCode(String universityTypeCode) {
        this.universityTypeCode = universityTypeCode;
    }

	public String getUniverstiyTypeDesc() {
        return universtiyTypeDesc;
    }

	public void setUniverstiyTypeDesc(String universtiyTypeDesc) {
        this.universtiyTypeDesc = universtiyTypeDesc;
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
    @Column(name = "university_type_id")
    private Integer universityTypeId;

	public Integer getUniversityTypeId() {
        return this.universityTypeId;
    }

	public void setUniversityTypeId(Integer id) {
        this.universityTypeId = id;
    }
}
