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
@Table(name="company_offer_details")
public class CompanyOffers implements Serializable {
	private Long CODID;
	private String offerName;
	private String offerDescription;
	private Date offerStartDate;
	private Date offerEndDate;
	private String status;
	private CompanyDetails companyDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODID")
	public Long getCODID() {
		return CODID;
	}
	public void setCODID(Long cODID) {
		CODID = cODID;
	}
	
	@Column(name="offer_name", nullable=false, length=100)
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
	@Column(name="offer_description", nullable=true, length=500)
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date", nullable=true, length=20)
	public Date getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date", nullable=true, length=20)
	public Date getOfferEndDate() {
		return offerEndDate;
	}
	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
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
	@Column(name="offer_status", nullable=true, length=10)
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
		result = prime * result + ((CODID == null) ? 0 : CODID.hashCode());
		result = prime * result
				+ ((companyDetails == null) ? 0 : companyDetails.hashCode());
		result = prime
				* result
				+ ((offerDescription == null) ? 0 : offerDescription.hashCode());
		result = prime * result
				+ ((offerEndDate == null) ? 0 : offerEndDate.hashCode());
		result = prime * result
				+ ((offerName == null) ? 0 : offerName.hashCode());
		result = prime * result
				+ ((offerStartDate == null) ? 0 : offerStartDate.hashCode());
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
		CompanyOffers other = (CompanyOffers) obj;
		if (CODID == null) {
			if (other.CODID != null)
				return false;
		} else if (!CODID.equals(other.CODID))
			return false;
		if (companyDetails == null) {
			if (other.companyDetails != null)
				return false;
		} else if (!companyDetails.equals(other.companyDetails))
			return false;
		if (offerDescription == null) {
			if (other.offerDescription != null)
				return false;
		} else if (!offerDescription.equals(other.offerDescription))
			return false;
		if (offerEndDate == null) {
			if (other.offerEndDate != null)
				return false;
		} else if (!offerEndDate.equals(other.offerEndDate))
			return false;
		if (offerName == null) {
			if (other.offerName != null)
				return false;
		} else if (!offerName.equals(other.offerName))
			return false;
		if (offerStartDate == null) {
			if (other.offerStartDate != null)
				return false;
		} else if (!offerStartDate.equals(other.offerStartDate))
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
		return "CompanyOffers [CODID=" + CODID + ", offerName=" + offerName
				+ ", offerDescription=" + offerDescription
				+ ", offerStartDate=" + offerStartDate + ", offerEndDate="
				+ offerEndDate + ", status=" + status + ", companyDetails="
				+ companyDetails + "]";
	}

}
