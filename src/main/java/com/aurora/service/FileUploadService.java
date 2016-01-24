package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.model.UploadFiles;
import com.aurora.util.FileUploadDTO;

public interface FileUploadService {

	String saveFile(MultipartHttpServletRequest request);
	List<FileUploadDTO> getFileDetailsTable(String sortField, int order, int start, int gridTableSize, Long caterogyId,Long companyId, Long fileImageCategoryId, String searchq);
	int getFileDetailsTableCount(Long caterogyId, Long companyId, Long fileImageCategoryId, String searchq);
	String deleteImage(long parseLong);
	List<FileUploadDTO> getImagesByImageCategoryId(Long fileImageCategoryId);
	UploadFiles getFileByUFID(Long ufid);

}
