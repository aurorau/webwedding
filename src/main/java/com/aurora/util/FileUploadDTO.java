package com.aurora.util;

import java.util.Date;

public class FileUploadDTO {
	private Long UFID;
	private String imageName;
	private String imageSize;
	private Date fileUploadDate;
	
	public Long getUFID() {
		return UFID;
	}
	public void setUFID(Long uFID) {
		UFID = uFID;
	}

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	public Date getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(Date fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	
}
