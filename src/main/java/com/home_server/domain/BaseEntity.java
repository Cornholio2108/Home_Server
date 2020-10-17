package com.home_server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity {
	@Column(name = "version")
	private int version;
	@Column(name = "deleted")
	private boolean deleted;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modification_date")
	private Date modificationDate;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public abstract Long getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? super.hashCode() : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {

		if (this == other) {
			return true;
		}

		if (this.getClass() != other.getClass()) {
			return false;
		}
		BaseEntity otherObj = (BaseEntity) other;

		return this.getId().equals(otherObj.getId());
	}
}
