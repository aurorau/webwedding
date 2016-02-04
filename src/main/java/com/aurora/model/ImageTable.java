package com.aurora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="image_table")
public class ImageTable implements Serializable {
	private Long ITID;
	private String imageName;
	private String imageType;
	private String imageSize;
	private byte[] imageContent;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITID")
	public Long getITID() {
		return ITID;
	}
	public void setITID(Long iTID) {
		ITID = iTID;
	}
	
	@Column(name="image_name", nullable=true, length=100)
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Column(name="image_type", nullable=true, length=100)
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	@Column(name="image_content", nullable=true)
	@Lob
	public byte[] getImageContent() {
		return imageContent;
	}
	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}
	@Column(name="image_size", nullable=true)
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ITID == null) ? 0 : ITID.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageSize == null) ? 0 : imageSize.hashCode());
		result = prime * result + ((imageType == null) ? 0 : imageType.hashCode());
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
		ImageTable other = (ImageTable) obj;
		if (ITID == null) {
			if (other.ITID != null)
				return false;
		} else if (!ITID.equals(other.ITID))
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
		return true;
	}
	@Override
	public String toString() {
		return "ImageTable [ITID=" + ITID + ", imageName=" + imageName + ", imageType=" + imageType + ", imageSize="
				+ imageSize + "]";
	}

}
