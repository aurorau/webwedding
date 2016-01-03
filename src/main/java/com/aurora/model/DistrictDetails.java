package com.aurora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="district_details")
public class DistrictDetails implements Serializable {
	
	private Long DDID;
	private String districtCode;
	private String districtName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DDID")
	public Long getDDID() {
		return DDID;
	}
	public void setDDID(Long dDID) {
		DDID = dDID;
	}
	
	@Column(name="district_code", nullable=true, length=100)
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	@Column(name="district_name", nullable=true, length=100)
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DDID == null) ? 0 : DDID.hashCode());
		result = prime * result + ((districtCode == null) ? 0 : districtCode.hashCode());
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
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
		DistrictDetails other = (DistrictDetails) obj;
		if (DDID == null) {
			if (other.DDID != null)
				return false;
		} else if (!DDID.equals(other.DDID))
			return false;
		if (districtCode == null) {
			if (other.districtCode != null)
				return false;
		} else if (!districtCode.equals(other.districtCode))
			return false;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DistrictDetails [DDID=" + DDID + ", districtCode=" + districtCode + ", districtName=" + districtName
				+ "]";
	}
}
