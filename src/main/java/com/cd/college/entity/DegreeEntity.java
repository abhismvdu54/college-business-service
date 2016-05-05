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
@Table(name = "degree")
public class DegreeEntity {

	@OneToMany(mappedBy = "degreeId")
    private Set<ProgramEntity> programs;

	@Column(name = "degree_code", length = 20, unique = true)
    @NotNull
    private String degreeCode;

	@Column(name = "degree_desc", length = 100)
    @NotNull
    private String degreeDesc;

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

	public Set<ProgramEntity> getPrograms() {
        return programs;
    }

	public void setPrograms(Set<ProgramEntity> programs) {
        this.programs = programs;
    }

	public String getDegreeCode() {
        return degreeCode;
    }

	public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

	public String getDegreeDesc() {
        return degreeDesc;
    }

	public void setDegreeDesc(String degreeDesc) {
        this.degreeDesc = degreeDesc;
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
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("programs").toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "degree_id")
    private Integer degreeId;

	public Integer getDegreeId() {
        return this.degreeId;
    }

	public void setDegreeId(Integer id) {
        this.degreeId = id;
    }
}
