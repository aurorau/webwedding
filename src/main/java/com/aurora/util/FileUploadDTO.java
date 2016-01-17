package com.aurora.util;

import java.util.Date;

public class FileUploadDTO {
	private Long UFID;
	private String fileUrl;
	private Date fileUploadDate;
	
	public Long getUFID() {
		return UFID;
	}
	public void setUFID(Long uFID) {
		UFID = uFID;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(Date fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	
}
