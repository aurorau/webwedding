package com.aurora.dao;

import java.util.List;

import com.aurora.model.UploadFiles;

public interface FileUploadDao {

	UploadFiles getFileDetailsByFUID(Long fuid);
	void saveFile(UploadFiles uploadFiles);
	List<UploadFiles> getFileDetailsTable(String sortField, int order, int start, int gridTableSize, Long caterogyId,Long companyId, String searchq);
	int getFileDetailsTableCount(Long caterogyId, Long companyId, String searchq);
	void deleteImage(long parseLong);

}
