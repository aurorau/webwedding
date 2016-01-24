package com.aurora.util;

public class ImageCategoryDTO {
	private Long ICID;
	private String icType;
	private String icName;
	private Long ITID;
/*	private String imageName;
	private String imageType;
	private String imageSize;
	private byte[] imageContent;*/
	
	public Long getICID() {
		return ICID;
	}
	public void setICID(Long iCID) {
		ICID = iCID;
	}
	public String getIcType() {
		return icType;
	}
	public void setIcType(String icType) {
		this.icType = icType;
	}
	public String getIcName() {
		return icName;
	}
	public void setIcName(String icName) {
		this.icName = icName;
	}
	public Long getITID() {
		return ITID;
	}
	public void setITID(Long iTID) {
		ITID = iTID;
	}
/*	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	public byte[] getImageContent() {
		return imageContent;
	}
	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}*/
	
	
}
