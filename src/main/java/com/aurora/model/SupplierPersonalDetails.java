package com.aurora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier_personal_details")
public class SupplierPersonalDetails implements Serializable {
	
	private Long SPDID;
	private String supplierFirstName;
	private String supplierLastName;
	private String supplierEmail;
	private String supplierTp1;
	private String supplierTp2;
	private String supplierSkypeAddress;
	
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
	@Column(name="supplier_skype_address", nullable=true, length=100)
	public String getSupplierSkypeAddress() {
		return supplierSkypeAddress;
	}
	@Column(name="supplier_tp1", nullable=true, length=100)
	public String getSupplierTp1() {
		return supplierTp1;
	}
	public void setSupplierTp1(String supplierTp1) {
		this.supplierTp1 = supplierTp1;
	}
	@Column(name="supplier_tp2", nullable=true, length=100)
	public String getSupplierTp2() {
		return supplierTp2;
	}
	public void setSupplierTp2(String supplierTp2) {
		this.supplierTp2 = supplierTp2;
	}
	public void setSupplierSkypeAddress(String supplierSkypeAddress) {
		this.supplierSkypeAddress = supplierSkypeAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SPDID == null) ? 0 : SPDID.hashCode());
		result = prime * result + ((supplierEmail == null) ? 0 : supplierEmail.hashCode());
		result = prime * result + ((supplierFirstName == null) ? 0 : supplierFirstName.hashCode());
		result = prime * result + ((supplierLastName == null) ? 0 : supplierLastName.hashCode());
		result = prime * result + ((supplierSkypeAddress == null) ? 0 : supplierSkypeAddress.hashCode());
		result = prime * result + ((supplierTp1 == null) ? 0 : supplierTp1.hashCode());
		result = prime * result + ((supplierTp2 == null) ? 0 : supplierTp2.hashCode());
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
		if (supplierTp1 == null) {
			if (other.supplierTp1 != null)
				return false;
		} else if (!supplierTp1.equals(other.supplierTp1))
			return false;
		if (supplierTp2 == null) {
			if (other.supplierTp2 != null)
				return false;
		} else if (!supplierTp2.equals(other.supplierTp2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplierPersonalDetails [SPDID=" + SPDID + ", supplierFirstName=" + supplierFirstName
				+ ", supplierLastName=" + supplierLastName + ", supplierEmail=" + supplierEmail + ", supplierTp1="
				+ supplierTp1 + ", supplierTp2=" + supplierTp2 + ", supplierSkypeAddress=" + supplierSkypeAddress + "]";
	}
}
