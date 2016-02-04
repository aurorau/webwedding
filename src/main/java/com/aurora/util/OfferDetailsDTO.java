package com.aurora.util;

import java.util.Date;

import com.aurora.model.CompanyDetails;

public class OfferDetailsDTO {
	private Long CODID;
	private String offerName;
	private String offerDescription;
	private Date offerStartDate;
	private Date offerEndDate;
	private String status;
	private Long companyId;
	
	public Long getCODID() {
		return CODID;
	}
	public void setCODID(Long cODID) {
		CODID = cODID;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public Date getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	public Date getOfferEndDate() {
		return offerEndDate;
	}
	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	

	
}
