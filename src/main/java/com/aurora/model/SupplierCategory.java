package com.aurora.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="supplier_category")
public class SupplierCategory implements Serializable {
	
	private Long SCID;
	private String scType;
	private String scName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SCID")
	public Long getSCID() {
		return SCID;
	}
	public void setSCID(Long sCID) {
		SCID = sCID;
	}
	
	@Column(name="sc_type", nullable=true, length=100)
	public String getScType() {
		return scType;
	}
	public void setScType(String scType) {
		this.scType = scType;
	}
	
	@Column(name="sc_name", nullable=true, length=100)
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SCID == null) ? 0 : SCID.hashCode());
		result = prime * result + ((scName == null) ? 0 : scName.hashCode());
		result = prime * result + ((scType == null) ? 0 : scType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierCategory other = (SupplierCategory) obj;
		if (SCID == null) {
			if (other.SCID != null)
				return false;
		} else if (!SCID.equals(other.SCID))
			return false;
		if (scName == null) {
			if (other.scName != null)
				return false;
		} else if (!scName.equals(other.scName))
			return false;
		if (scType == null) {
			if (other.scType != null)
				return false;
		} else if (!scType.equals(other.scType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplierCategory [SCID=" + SCID + ", scType=" + scType + ", scName=" + scName + "]";
	}

}
