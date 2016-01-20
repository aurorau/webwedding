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
@Table(name="upload_files")
public class UploadFiles implements Serializable {
	
	private Long UFID;
	private String fileUrl;
	private String fileName;
	private String fileType;
	private Date fileUploadDate;
	private SupplierCategory supplierCategory;
	private CompanyDetails supplierCompanyDetails;
	private ImageCategory imageCategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UFID")
	public Long getUFID() {
		return UFID;
	}
	public void setUFID(Long uFID) {
		UFID = uFID;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCDID", nullable=true)
	@JsonIgnore
	public CompanyDetails getSupplierCompanyDetails() {
		return supplierCompanyDetails;
	}
	
	@Column(name="file_url", nullable=true, length=250)
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	@Column(name="file_name", nullable=true, length=200)
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name="file_type", nullable=true, length=50)
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setSupplierCompanyDetails(CompanyDetails supplierCompanyDetails) {
		this.supplierCompanyDetails = supplierCompanyDetails;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCID", nullable=true)
	@JsonIgnore
	public SupplierCategory getSupplierCategory() {
		return supplierCategory;
	}
	public void setSupplierCategory(SupplierCategory supplierCategory) {
		this.supplierCategory = supplierCategory;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="file_upload_date", nullable=false, length=50)
	public Date getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(Date fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FICID", nullable=true)
	@JsonIgnore
	public ImageCategory getImageCategory() {
		return imageCategory;
	}
	public void setImageCategory(ImageCategory imageCategory) {
		this.imageCategory = imageCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UFID == null) ? 0 : UFID.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((fileUploadDate == null) ? 0 : fileUploadDate.hashCode());
		result = prime * result + ((fileUrl == null) ? 0 : fileUrl.hashCode());
		result = prime * result + ((imageCategory == null) ? 0 : imageCategory.hashCode());
		result = prime * result + ((supplierCategory == null) ? 0 : supplierCategory.hashCode());
		result = prime * result + ((supplierCompanyDetails == null) ? 0 : supplierCompanyDetails.hashCode());
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
		UploadFiles other = (UploadFiles) obj;
		if (UFID == null) {
			if (other.UFID != null)
				return false;
		} else if (!UFID.equals(other.UFID))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (fileUploadDate == null) {
			if (other.fileUploadDate != null)
				return false;
		} else if (!fileUploadDate.equals(other.fileUploadDate))
			return false;
		if (fileUrl == null) {
			if (other.fileUrl != null)
				return false;
		} else if (!fileUrl.equals(other.fileUrl))
			return false;
		if (imageCategory == null) {
			if (other.imageCategory != null)
				return false;
		} else if (!imageCategory.equals(other.imageCategory))
			return false;
		if (supplierCategory == null) {
			if (other.supplierCategory != null)
				return false;
		} else if (!supplierCategory.equals(other.supplierCategory))
			return false;
		if (supplierCompanyDetails == null) {
			if (other.supplierCompanyDetails != null)
				return false;
		} else if (!supplierCompanyDetails.equals(other.supplierCompanyDetails))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UploadFiles [UFID=" + UFID + ", fileUrl=" + fileUrl + ", fileName=" + fileName + ", fileType="
				+ fileType + ", fileUploadDate=" + fileUploadDate + ", supplierCategory=" + supplierCategory
				+ ", supplierCompanyDetails=" + supplierCompanyDetails + ", imageCategory=" + imageCategory + "]";
	}

}
