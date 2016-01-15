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
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="company_gallery")
public class CompanyGallery implements Serializable {
	
	private Long CMGID;
	private String imageUrl;
	private String imageName;
	private CompanyDetails supplierCompanyDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CMGID")
	public Long getCMGID() {
		return CMGID;
	}
	public void setCMGID(Long cMGID) {
		CMGID = cMGID;
	}
	
	@Column(name="image_url", nullable=true, length=100)
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Column(name="image_name", nullable=true, length=100)
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FSCDID", nullable=false)
	@JsonIgnore
	public CompanyDetails getSupplierCompanyDetails() {
		return supplierCompanyDetails;
	}
	public void setSupplierCompanyDetails(CompanyDetails supplierCompanyDetails) {
		this.supplierCompanyDetails = supplierCompanyDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CMGID == null) ? 0 : CMGID.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
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
		CompanyGallery other = (CompanyGallery) obj;
		if (CMGID == null) {
			if (other.CMGID != null)
				return false;
		} else if (!CMGID.equals(other.CMGID))
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
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
		return "CompanyGallery [CMGID=" + CMGID + ", imageUrl=" + imageUrl + ", imageName=" + imageName
				+ ", supplierCompanyDetails=" + supplierCompanyDetails + "]";
	}

}
