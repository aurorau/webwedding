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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="supplier_company_details")
public class SupplierCompanyDetails implements Serializable {
	
	private Long SCDID;
	private String companyName;
	private String companyAddress;
	private String companyTp;
	private String companyEmail;
	private String companyFaxNo;
	private String companyWebURl;
	private String companyFbPage;
	private Long budget;
	private String status;
	private SupplierPersonalDetails supplierPersonalDetails;
	private SupplierCategory supplierCategory;
	private DistrictDetails districtDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SCDID")
	public Long getSCDID() {
		return SCDID;
	}
	public void setSCDID(Long sCDID) {
		SCDID = sCDID;
	}
	
	@Column(name="company_name", nullable=true, length=100)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="company_address", nullable=true, length=100)
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	@Column(name="company_tp", nullable=true, length=100)
	public String getCompanyTp() {
		return companyTp;
	}
	public void setCompanyTp(String companyTp) {
		this.companyTp = companyTp;
	}
	
	@Column(name="company_email", nullable=true, length=100)
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	@Column(name="company_fax_no", nullable=true, length=100)
	public String getCompanyFaxNo() {
		return companyFaxNo;
	}
	public void setCompanyFaxNo(String companyFaxNo) {
		this.companyFaxNo = companyFaxNo;
	}
	
	@Column(name="company_web_URl", nullable=true, length=100)
	public String getCompanyWebURl() {
		return companyWebURl;
	}
	public void setCompanyWebURl(String companyWebURl) {
		this.companyWebURl = companyWebURl;
	}
	
	@Column(name="company_fb_page", nullable=true, length=100)
	public String getCompanyFbPage() {
		return companyFbPage;
	}
	public void setCompanyFbPage(String companyFbPage) {
		this.companyFbPage = companyFbPage;
	}
	
	@Column(name="budget", nullable=true, length=100)
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	
	@Column(name="status", nullable=true, length=100)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSPDID", nullable=false)
	@JsonIgnore
	public SupplierPersonalDetails getSupplierPersonalDetails() {
		return supplierPersonalDetails;
	}
	
	public void setSupplierPersonalDetails(SupplierPersonalDetails supplierPersonalDetails) {
		this.supplierPersonalDetails = supplierPersonalDetails;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCID", nullable=false)
	@JsonIgnore
	public SupplierCategory getSupplierCategory() {
		return supplierCategory;
	}
	public void setSupplierCategory(SupplierCategory supplierCategory) {
		this.supplierCategory = supplierCategory;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FDDID", nullable=false)
	@JsonIgnore
	public DistrictDetails getDistrictDetails() {
		return districtDetails;
	}
	public void setDistrictDetails(DistrictDetails districtDetails) {
		this.districtDetails = districtDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SCDID == null) ? 0 : SCDID.hashCode());
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((companyAddress == null) ? 0 : companyAddress.hashCode());
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((companyFaxNo == null) ? 0 : companyFaxNo.hashCode());
		result = prime * result + ((companyFbPage == null) ? 0 : companyFbPage.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((companyTp == null) ? 0 : companyTp.hashCode());
		result = prime * result + ((companyWebURl == null) ? 0 : companyWebURl.hashCode());
		result = prime * result + ((districtDetails == null) ? 0 : districtDetails.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supplierCategory == null) ? 0 : supplierCategory.hashCode());
		result = prime * result + ((supplierPersonalDetails == null) ? 0 : supplierPersonalDetails.hashCode());
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
		SupplierCompanyDetails other = (SupplierCompanyDetails) obj;
		if (SCDID == null) {
			if (other.SCDID != null)
				return false;
		} else if (!SCDID.equals(other.SCDID))
			return false;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (companyAddress == null) {
			if (other.companyAddress != null)
				return false;
		} else if (!companyAddress.equals(other.companyAddress))
			return false;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyFaxNo == null) {
			if (other.companyFaxNo != null)
				return false;
		} else if (!companyFaxNo.equals(other.companyFaxNo))
			return false;
		if (companyFbPage == null) {
			if (other.companyFbPage != null)
				return false;
		} else if (!companyFbPage.equals(other.companyFbPage))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyTp == null) {
			if (other.companyTp != null)
				return false;
		} else if (!companyTp.equals(other.companyTp))
			return false;
		if (companyWebURl == null) {
			if (other.companyWebURl != null)
				return false;
		} else if (!companyWebURl.equals(other.companyWebURl))
			return false;
		if (districtDetails == null) {
			if (other.districtDetails != null)
				return false;
		} else if (!districtDetails.equals(other.districtDetails))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supplierCategory == null) {
			if (other.supplierCategory != null)
				return false;
		} else if (!supplierCategory.equals(other.supplierCategory))
			return false;
		if (supplierPersonalDetails == null) {
			if (other.supplierPersonalDetails != null)
				return false;
		} else if (!supplierPersonalDetails.equals(other.supplierPersonalDetails))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplierCompanyDetails [SCDID=" + SCDID + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", companyTp=" + companyTp + ", companyEmail=" + companyEmail + ", companyFaxNo="
				+ companyFaxNo + ", companyWebURl=" + companyWebURl + ", companyFbPage=" + companyFbPage + ", budget="
				+ budget + ", status=" + status + ", supplierPersonalDetails=" + supplierPersonalDetails
				+ ", supplierCategory=" + supplierCategory + ", districtDetails=" + districtDetails + "]";
	}

}
