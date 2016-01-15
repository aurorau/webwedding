package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.aurora.model.UploadFiles;

public interface FileUploadService {

	String saveFile(HttpServletRequest request);
	List<UploadFiles> getFileDetailsTable(String sortField, int order, int start, int gridTableSize, Long caterogyId,Long companyId, String searchq);
	int getFileDetailsTableCount(Long caterogyId, Long companyId, String searchq);
	String deleteImage(long parseLong);

}
