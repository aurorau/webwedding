package com.aurora.dao;

import java.util.List;

import com.aurora.model.UploadFiles;
import com.aurora.util.FileUploadDTO;

public interface FileUploadDao {

	UploadFiles getFileDetailsByFUID(Long fuid);
	void saveFile(UploadFiles uploadFiles);
	List<FileUploadDTO> getFileDetailsTable(String sortField, int order, int start, int gridTableSize, Long caterogyId,Long companyId, Long fileImageCategoryId, String searchq);
	int getFileDetailsTableCount(Long caterogyId, Long companyId, Long fileImageCategoryId, String searchq);
	void deleteImage(long parseLong) throws Exception;
	List<FileUploadDTO> getFileDetailsByCompanyId(Long scdid);
	List<FileUploadDTO> getImagesByImageCategoryId(Long fileImageCategoryId);
	UploadFiles getFileDetailsByName(String string);
	UploadFiles getFileByUFID(Long ufid);

}
