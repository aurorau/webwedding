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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="add_details")
public class AddDetails implements Serializable {
	
	private Long AID;
	private String addSupplierName;
	private String addSupplierTp;
	private String addSupplierAddress;
	private String addSupplierEmail;
	private String addDescription;
	//private SupplierCategory addCategory;
	private String addStatus;
	private Date addRegisteredDate;
	private Date addActiveDate;
	private Long addActivePeriod;
	private String addUrl;
	private String addLink;
	private ImageTable imageTable;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AID")
	public Long getAID() {
		return AID;
	}
	public void setAID(Long aID) {
		AID = aID;
	}
	
	@Column(name="add_supplier_name", nullable=true, length=150)
	public String getAddSupplierName() {
		return addSupplierName;
	}
	public void setAddSupplierName(String addSupplierName) {
		this.addSupplierName = addSupplierName;
	}
	
	@Column(name="add_supplier_tp", nullable=true, length=100)
	public String getAddSupplierTp() {
		return addSupplierTp;
	}
	public void setAddSupplierTp(String addSupplierTp) {
		this.addSupplierTp = addSupplierTp;
	}
	
	@Column(name="add_supplier_address", nullable=true, length=200)
	public String getAddSupplierAddress() {
		return addSupplierAddress;
	}
	public void setAddSupplierAddress(String addSupplierAddress) {
		this.addSupplierAddress = addSupplierAddress;
	}
	
	@Column(name="add_supplier_email", nullable=true, length=100)
	public String getAddSupplierEmail() {
		return addSupplierEmail;
	}
	public void setAddSupplierEmail(String addSupplierEmail) {
		this.addSupplierEmail = addSupplierEmail;
	}
	
	@Column(name="add_description", nullable=true, length=500)
	public String getAddDescription() {
		return addDescription;
	}
	public void setAddDescription(String addDescription) {
		this.addDescription = addDescription;
	}
	
/*	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCID", nullable=false)
	@JsonIgnore
	public SupplierCategory getAddCategory() {
		return addCategory;
	}
	public void setAddCategory(SupplierCategory addCategory) {
		this.addCategory = addCategory;
	}*/
	
	@Column(name="add_status", nullable=true)
	public String getAddStatus() {
		return addStatus;
	}
	
	public void setAddStatus(String addStatus) {
		this.addStatus = addStatus;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="add_registered_date", nullable=true, length=20)
	public Date getAddRegisteredDate() {
		return addRegisteredDate;
	}
	public void setAddRegisteredDate(Date addRegisteredDate) {
		this.addRegisteredDate = addRegisteredDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="add_active_date", nullable=true, length=20)
	public Date getAddActiveDate() {
		return addActiveDate;
	}
	public void setAddActiveDate(Date addActiveDate) {
		this.addActiveDate = addActiveDate;
	}
	
	@Column(name="add_active_period", nullable=true, length=20)
	public Long getAddActivePeriod() {
		return addActivePeriod;
	}
	public void setAddActivePeriod(Long addActivePeriod) {
		this.addActivePeriod = addActivePeriod;
	}
	
	@Column(name="add_url", nullable=true, length=150)
	public String getAddUrl() {
		return addUrl;
	}
	public void setAddUrl(String addUrl) {
		this.addUrl = addUrl;
	}
	
	@Column(name="add_link", nullable=true, length=200)
	public String getAddLink() {
		return addLink;
	}
	public void setAddLink(String addLink) {
		this.addLink = addLink;
	}
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FITID", nullable=true)
	@JsonIgnore
	public ImageTable getImageTable() {
		return imageTable;
	}
	public void setImageTable(ImageTable imageTable) {
		this.imageTable = imageTable;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AID == null) ? 0 : AID.hashCode());
		result = prime * result + ((addActiveDate == null) ? 0 : addActiveDate.hashCode());
		result = prime * result + ((addActivePeriod == null) ? 0 : addActivePeriod.hashCode());
		result = prime * result + ((addDescription == null) ? 0 : addDescription.hashCode());
		result = prime * result + ((addLink == null) ? 0 : addLink.hashCode());
		result = prime * result + ((addRegisteredDate == null) ? 0 : addRegisteredDate.hashCode());
		result = prime * result + ((addStatus == null) ? 0 : addStatus.hashCode());
		result = prime * result + ((addSupplierAddress == null) ? 0 : addSupplierAddress.hashCode());
		result = prime * result + ((addSupplierEmail == null) ? 0 : addSupplierEmail.hashCode());
		result = prime * result + ((addSupplierName == null) ? 0 : addSupplierName.hashCode());
		result = prime * result + ((addSupplierTp == null) ? 0 : addSupplierTp.hashCode());
		result = prime * result + ((addUrl == null) ? 0 : addUrl.hashCode());
		result = prime * result + ((imageTable == null) ? 0 : imageTable.hashCode());
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
		AddDetails other = (AddDetails) obj;
		if (AID == null) {
			if (other.AID != null)
				return false;
		} else if (!AID.equals(other.AID))
			return false;
		if (addActiveDate == null) {
			if (other.addActiveDate != null)
				return false;
		} else if (!addActiveDate.equals(other.addActiveDate))
			return false;
		if (addActivePeriod == null) {
			if (other.addActivePeriod != null)
				return false;
		} else if (!addActivePeriod.equals(other.addActivePeriod))
			return false;
		if (addDescription == null) {
			if (other.addDescription != null)
				return false;
		} else if (!addDescription.equals(other.addDescription))
			return false;
		if (addLink == null) {
			if (other.addLink != null)
				return false;
		} else if (!addLink.equals(other.addLink))
			return false;
		if (addRegisteredDate == null) {
			if (other.addRegisteredDate != null)
				return false;
		} else if (!addRegisteredDate.equals(other.addRegisteredDate))
			return false;
		if (addStatus == null) {
			if (other.addStatus != null)
				return false;
		} else if (!addStatus.equals(other.addStatus))
			return false;
		if (addSupplierAddress == null) {
			if (other.addSupplierAddress != null)
				return false;
		} else if (!addSupplierAddress.equals(other.addSupplierAddress))
			return false;
		if (addSupplierEmail == null) {
			if (other.addSupplierEmail != null)
				return false;
		} else if (!addSupplierEmail.equals(other.addSupplierEmail))
			return false;
		if (addSupplierName == null) {
			if (other.addSupplierName != null)
				return false;
		} else if (!addSupplierName.equals(other.addSupplierName))
			return false;
		if (addSupplierTp == null) {
			if (other.addSupplierTp != null)
				return false;
		} else if (!addSupplierTp.equals(other.addSupplierTp))
			return false;
		if (addUrl == null) {
			if (other.addUrl != null)
				return false;
		} else if (!addUrl.equals(other.addUrl))
			return false;
		if (imageTable == null) {
			if (other.imageTable != null)
				return false;
		} else if (!imageTable.equals(other.imageTable))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddDetails [AID=" + AID + ", addSupplierName=" + addSupplierName + ", addSupplierTp=" + addSupplierTp
				+ ", addSupplierAddress=" + addSupplierAddress + ", addSupplierEmail=" + addSupplierEmail
				+ ", addDescription=" + addDescription + ", addStatus=" + addStatus + ", addRegisteredDate="
				+ addRegisteredDate + ", addActiveDate=" + addActiveDate + ", addActivePeriod=" + addActivePeriod
				+ ", addUrl=" + addUrl + ", addLink=" + addLink + ", imageTable=" + imageTable + "]";
	}

}
