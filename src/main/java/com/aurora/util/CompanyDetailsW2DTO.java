package com.aurora.util;

import java.util.List;

public class CompanyDetailsW2DTO {
	private Long SCDID;
	private String companyName;
	private String companyAddress;
	private String companyTp1;
	private String companyTp2;
	private String companyEmail;
	private String companyFaxNo;
	private String companyWebURl;
	private String companyFbPage;
	private String supplierPersonalDetailsFName;
	private String supplierPersonalDetailsFLName;
	private String supplierPersonalDetailsSkype;
	private Long ITID;
	private Long budget;
	private Long packageCount;
	private Boolean offerAvailable;
	
	public Long getSCDID() {
		return SCDID;
	}
	public void setSCDID(Long sCDID) {
		SCDID = sCDID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public Long getITID() {
		return ITID;
	}
	public void setITID(Long iTID) {
		ITID = iTID;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTp1() {
		return companyTp1;
	}
	public void setCompanyTp1(String companyTp1) {
		this.companyTp1 = companyTp1;
	}
	public String getCompanyTp2() {
		return companyTp2;
	}
	public void setCompanyTp2(String companyTp2) {
		this.companyTp2 = companyTp2;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyFaxNo() {
		return companyFaxNo;
	}
	public void setCompanyFaxNo(String companyFaxNo) {
		this.companyFaxNo = companyFaxNo;
	}
	public String getCompanyWebURl() {
		return companyWebURl;
	}
	public void setCompanyWebURl(String companyWebURl) {
		this.companyWebURl = companyWebURl;
	}
	public String getCompanyFbPage() {
		return companyFbPage;
	}
	public void setCompanyFbPage(String companyFbPage) {
		this.companyFbPage = companyFbPage;
	}
	public String getSupplierPersonalDetailsFName() {
		return supplierPersonalDetailsFName;
	}
	public void setSupplierPersonalDetailsFName(String supplierPersonalDetailsFName) {
		this.supplierPersonalDetailsFName = supplierPersonalDetailsFName;
	}
	public String getSupplierPersonalDetailsFLName() {
		return supplierPersonalDetailsFLName;
	}
	public void setSupplierPersonalDetailsFLName(String supplierPersonalDetailsFLName) {
		this.supplierPersonalDetailsFLName = supplierPersonalDetailsFLName;
	}
	public String getSupplierPersonalDetailsSkype() {
		return supplierPersonalDetailsSkype;
	}
	public void setSupplierPersonalDetailsSkype(String supplierPersonalDetailsSkype) {
		this.supplierPersonalDetailsSkype = supplierPersonalDetailsSkype;
	}

	public Long getPackageCount() {
		return packageCount;
	}
	public void setPackageCount(Long packageCount) {
		this.packageCount = packageCount;
	}
	public Boolean getOfferAvailable() {
		return offerAvailable;
	}
	public void setOfferAvailable(Boolean offerAvailable) {
		this.offerAvailable = offerAvailable;
	}
	
}
