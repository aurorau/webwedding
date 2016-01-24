package com.aurora.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="image_category")
public class ImageCategory implements Serializable{
	private Long ICID;
	private String icType;
	private String icName;
	private String icLogoUrl;
	private ImageTable imageTable;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ICID")
	public Long getICID() {
		return ICID;
	}
	public void setICID(Long iCID) {
		ICID = iCID;
	}
	
	@Column(name="ic_type", nullable=true, length=100)
	public String getIcType() {
		return icType;
	}
	public void setIcType(String icType) {
		this.icType = icType;
	}
	
	@Column(name="ic_name", nullable=true, length=100)
	public String getIcName() {
		return icName;
	}
	public void setIcName(String icName) {
		this.icName = icName;
	}
	
	@Column(name="ic_logo_url", nullable=true, length=250)
	public String getIcLogoUrl() {
		return icLogoUrl;
	}
	public void setIcLogoUrl(String icLogoUrl) {
		this.icLogoUrl = icLogoUrl;
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
		result = prime * result + ((ICID == null) ? 0 : ICID.hashCode());
		result = prime * result + ((icLogoUrl == null) ? 0 : icLogoUrl.hashCode());
		result = prime * result + ((icName == null) ? 0 : icName.hashCode());
		result = prime * result + ((icType == null) ? 0 : icType.hashCode());
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
		ImageCategory other = (ImageCategory) obj;
		if (ICID == null) {
			if (other.ICID != null)
				return false;
		} else if (!ICID.equals(other.ICID))
			return false;
		if (icLogoUrl == null) {
			if (other.icLogoUrl != null)
				return false;
		} else if (!icLogoUrl.equals(other.icLogoUrl))
			return false;
		if (icName == null) {
			if (other.icName != null)
				return false;
		} else if (!icName.equals(other.icName))
			return false;
		if (icType == null) {
			if (other.icType != null)
				return false;
		} else if (!icType.equals(other.icType))
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
		return "ImageCategory [ICID=" + ICID + ", icType=" + icType + ", icName=" + icName + ", icLogoUrl=" + icLogoUrl
				+ ", imageTable=" + imageTable + "]";
	}

}
