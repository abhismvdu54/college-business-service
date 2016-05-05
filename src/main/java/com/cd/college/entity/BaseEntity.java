
package com.cd.college.entity;

/**
 * @author Mayank
 * 
 */
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.cd.college.constant.StatusType;

@MappedSuperclass
public abstract class BaseEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    private Date createdOn;

    private Integer createdBy;

    private Integer lastModifiedBy;

    private Date lastModifiedOn;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    public StatusType getStatus() {
	return status;
    }

    public void setStatus(StatusType status) {
	this.status = status;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @PreUpdate
    public void preUpdate() {
	lastModifiedOn = new Date();
    }

    @PrePersist
    public void prePersist() {
	Date currentDate = new Date();
	createdOn = currentDate;
	lastModifiedOn = currentDate;
    }

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
}
