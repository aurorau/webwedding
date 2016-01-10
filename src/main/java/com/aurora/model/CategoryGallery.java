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
//import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="category_gallery")
public class CategoryGallery implements Serializable {

	private Long CTGID;
	private String imageUrl;
	private String imageName;
	private SupplierCategory supplierCategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CTGID")
	public Long getCTGID() {
		return CTGID;
	}
	public void setCTGID(Long cTGID) {
		CTGID = cTGID;
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
	@JoinColumn(name="FSCID", nullable=false)
	@JsonIgnore
	public SupplierCategory getSupplierCategory() {
		return supplierCategory;
	}
	public void setSupplierCategory(SupplierCategory supplierCategory) {
		this.supplierCategory = supplierCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CTGID == null) ? 0 : CTGID.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((supplierCategory == null) ? 0 : supplierCategory.hashCode());
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
		CategoryGallery other = (CategoryGallery) obj;
		if (CTGID == null) {
			if (other.CTGID != null)
				return false;
		} else if (!CTGID.equals(other.CTGID))
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
		if (supplierCategory == null) {
			if (other.supplierCategory != null)
				return false;
		} else if (!supplierCategory.equals(other.supplierCategory))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CategoryGallery [CTGID=" + CTGID + ", imageUrl=" + imageUrl + ", imageName=" + imageName
				+ ", supplierCategory=" + supplierCategory + "]";
	}

}
