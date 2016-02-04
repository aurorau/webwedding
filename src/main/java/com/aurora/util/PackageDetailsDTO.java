package com.aurora.util;

import com.aurora.model.CompanyDetails;

public class PackageDetailsDTO {
	private Long CPDID;
	private String packageName;
	private String packageDescription;
	private String status;
	private Long companyId;
	
	public Long getCPDID() {
		return CPDID;
	}
	public void setCPDID(Long cPDID) {
		CPDID = cPDID;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
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
