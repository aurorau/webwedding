package com.aurora.util;

import java.util.Date;
import java.util.List;

import com.aurora.model.SupplierPersonalDetails;

public class CompanyDetailsDTO {
	private Long SCDID;
	private String companyName;
	private String companyAddress;
	private String companyTp1;
	private String companyTp2;
	private String companyEmail;
	private String companyFaxNo;
	private String companyWebURl;
	private String companyFbPage;
	private String logoUrl;
	private Long budget;
	private String status;
	private Date companyRegisteredDate;
	private String companyRegistrationNumber;
	private Date activeDate;
	private Long activePeriod;
	private Long supplierPersonalDetails;
	private String supplierPersonalDetailsFName;
	private Long supplierCategory;
	private Long districtDetails;
	private List<String> companyImageUrls;
	
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
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCompanyRegisteredDate() {
		return companyRegisteredDate;
	}
	public void setCompanyRegisteredDate(Date companyRegisteredDate) {
		this.companyRegisteredDate = companyRegisteredDate;
	}
	public String getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}
	public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}
	public Date getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	public Long getActivePeriod() {
		return activePeriod;
	}
	public void setActivePeriod(Long activePeriod) {
		this.activePeriod = activePeriod;
	}

	public Long getSupplierPersonalDetails() {
		return supplierPersonalDetails;
	}
	public void setSupplierPersonalDetails(Long supplierPersonalDetails) {
		this.supplierPersonalDetails = supplierPersonalDetails;
	}
	public Long getSupplierCategory() {
		return supplierCategory;
	}
	public void setSupplierCategory(Long supplierCategory) {
		this.supplierCategory = supplierCategory;
	}
	public Long getDistrictDetails() {
		return districtDetails;
	}
	public void setDistrictDetails(Long districtDetails) {
		this.districtDetails = districtDetails;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getSupplierPersonalDetailsFName() {
		return supplierPersonalDetailsFName;
	}
	public void setSupplierPersonalDetailsFName(String supplierPersonalDetailsFName) {
		this.supplierPersonalDetailsFName = supplierPersonalDetailsFName;
	}
	public List<String> getCompanyImageUrls() {
		return companyImageUrls;
	}
	public void setCompanyImageUrls(List<String> companyImageUrls) {
		this.companyImageUrls = companyImageUrls;
	}
}
