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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="upload_files")
public class UploadFiles implements Serializable {
	
	private Long UFID;
	private String imageName;
	private String imageType;
	private String imageSize;
	private byte[] imageContent;
	private Date fileUploadDate;
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
	public void setSupplierCompanyDetails(CompanyDetails supplierCompanyDetails) {
		this.supplierCompanyDetails = supplierCompanyDetails;
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
	@Column(name="image_name", nullable=true)
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Column(name="image_type", nullable=true)
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	@Column(name="image_size", nullable=true)
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	@Column(name="image_content", nullable=true)
	//@Lob
	public byte[] getImageContent() {
		return imageContent;
	}
	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UFID == null) ? 0 : UFID.hashCode());
		result = prime * result + ((fileUploadDate == null) ? 0 : fileUploadDate.hashCode());
		result = prime * result + ((imageCategory == null) ? 0 : imageCategory.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageSize == null) ? 0 : imageSize.hashCode());
		result = prime * result + ((imageType == null) ? 0 : imageType.hashCode());
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
		if (fileUploadDate == null) {
			if (other.fileUploadDate != null)
				return false;
		} else if (!fileUploadDate.equals(other.fileUploadDate))
			return false;
		if (imageCategory == null) {
			if (other.imageCategory != null)
				return false;
		} else if (!imageCategory.equals(other.imageCategory))
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (imageSize == null) {
			if (other.imageSize != null)
				return false;
		} else if (!imageSize.equals(other.imageSize))
			return false;
		if (imageType == null) {
			if (other.imageType != null)
				return false;
		} else if (!imageType.equals(other.imageType))
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
		return "UploadFiles [UFID=" + UFID + ", imageName=" + imageName + ", imageType=" + imageType + ", imageSize="
				+ imageSize + ", fileUploadDate=" + fileUploadDate + ", supplierCompanyDetails="
				+ supplierCompanyDetails + ", imageCategory=" + imageCategory + "]";
	}

}
