package com.aurora.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="company_package_details")
public class CompanyPackageDetails implements Serializable {
	
	private Long CPDID;
	private String packageName;
	private String packageDescription;
	private String status;
	private CompanyDetails companyDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CPDID")
	public Long getCPDID() {
		return CPDID;
	}
	public void setCPDID(Long cPDID) {
		CPDID = cPDID;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FCDID", nullable=false)
	@JsonIgnore
	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}
	
	@Column(name="package_name", length=100)
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	@Column(name="package_description", length=100)
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}
	@Column(name="package_status", length=100)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPDID == null) ? 0 : CPDID.hashCode());
		result = prime * result
				+ ((companyDetails == null) ? 0 : companyDetails.hashCode());
		result = prime
				* result
				+ ((packageDescription == null) ? 0 : packageDescription
						.hashCode());
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CompanyPackageDetails other = (CompanyPackageDetails) obj;
		if (CPDID == null) {
			if (other.CPDID != null)
				return false;
		} else if (!CPDID.equals(other.CPDID))
			return false;
		if (companyDetails == null) {
			if (other.companyDetails != null)
				return false;
		} else if (!companyDetails.equals(other.companyDetails))
			return false;
		if (packageDescription == null) {
			if (other.packageDescription != null)
				return false;
		} else if (!packageDescription.equals(other.packageDescription))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompanyPackageDetails [CPDID=" + CPDID + ", packageName="
				+ packageName + ", packageDescription=" + packageDescription
				+ ", status=" + status + ", companyDetails=" + companyDetails
				+ "]";
	}

}
