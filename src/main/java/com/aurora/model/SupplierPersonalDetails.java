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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="supplier_personal_details")
public class SupplierPersonalDetails implements Serializable {
	
	private Long SPDID;
	private String supplierFirstName;
	private String supplierLastName;
	private String supplierEmail;
	private String supplierTp;
	private String supplierSkypeAddress;
	private SupplierCompanyDetails supplierCompanyDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SPDID")
	public Long getSPDID() {
		return SPDID;
	}
	public void setSPDID(Long sPDID) {
		SPDID = sPDID;
	}
	
	@Column(name="supplier_first_name", nullable=true, length=100)
	public String getSupplierFirstName() {
		return supplierFirstName;
	}
	public void setSupplierFirstName(String supplierFirstName) {
		this.supplierFirstName = supplierFirstName;
	}
	
	@Column(name="supplier_last_name", nullable=true, length=100)
	public String getSupplierLastName() {
		return supplierLastName;
	}
	public void setSupplierLastName(String supplierLastName) {
		this.supplierLastName = supplierLastName;
	}
	
	@Column(name="supplier_email", nullable=true, length=100)
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	
	@Column(name="supplier_tp", nullable=true, length=100)
	public String getSupplierTp() {
		return supplierTp;
	}
	public void setSupplierTp(String supplierTp) {
		this.supplierTp = supplierTp;
	}
	
	@Column(name="supplier_skype_address", nullable=true, length=100)
	public String getSupplierSkypeAddress() {
		return supplierSkypeAddress;
	}
	public void setSupplierSkypeAddress(String supplierSkypeAddress) {
		this.supplierSkypeAddress = supplierSkypeAddress;
	}
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCDID", nullable=false)
	@JsonIgnore
	public SupplierCompanyDetails getSupplierCompanyDetails() {
		return supplierCompanyDetails;
	}
	public void setSupplierCompanyDetails(SupplierCompanyDetails supplierCompanyDetails) {
		this.supplierCompanyDetails = supplierCompanyDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SPDID == null) ? 0 : SPDID.hashCode());
		result = prime * result + ((supplierCompanyDetails == null) ? 0 : supplierCompanyDetails.hashCode());
		result = prime * result + ((supplierEmail == null) ? 0 : supplierEmail.hashCode());
		result = prime * result + ((supplierFirstName == null) ? 0 : supplierFirstName.hashCode());
		result = prime * result + ((supplierLastName == null) ? 0 : supplierLastName.hashCode());
		result = prime * result + ((supplierSkypeAddress == null) ? 0 : supplierSkypeAddress.hashCode());
		result = prime * result + ((supplierTp == null) ? 0 : supplierTp.hashCode());
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
		SupplierPersonalDetails other = (SupplierPersonalDetails) obj;
		if (SPDID == null) {
			if (other.SPDID != null)
				return false;
		} else if (!SPDID.equals(other.SPDID))
			return false;
		if (supplierCompanyDetails == null) {
			if (other.supplierCompanyDetails != null)
				return false;
		} else if (!supplierCompanyDetails.equals(other.supplierCompanyDetails))
			return false;
		if (supplierEmail == null) {
			if (other.supplierEmail != null)
				return false;
		} else if (!supplierEmail.equals(other.supplierEmail))
			return false;
		if (supplierFirstName == null) {
			if (other.supplierFirstName != null)
				return false;
		} else if (!supplierFirstName.equals(other.supplierFirstName))
			return false;
		if (supplierLastName == null) {
			if (other.supplierLastName != null)
				return false;
		} else if (!supplierLastName.equals(other.supplierLastName))
			return false;
		if (supplierSkypeAddress == null) {
			if (other.supplierSkypeAddress != null)
				return false;
		} else if (!supplierSkypeAddress.equals(other.supplierSkypeAddress))
			return false;
		if (supplierTp == null) {
			if (other.supplierTp != null)
				return false;
		} else if (!supplierTp.equals(other.supplierTp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplierPersonalDetails [SPDID=" + SPDID + ", supplierFirstName=" + supplierFirstName
				+ ", supplierLastName=" + supplierLastName + ", supplierEmail=" + supplierEmail + ", supplierTp="
				+ supplierTp + ", supplierSkypeAddress=" + supplierSkypeAddress + ", supplierCompanyDetails="
				+ supplierCompanyDetails + "]";
	}
	
}
