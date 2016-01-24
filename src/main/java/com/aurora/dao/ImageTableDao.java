package com.aurora.dao;

import com.aurora.model.ImageTable;

public interface ImageTableDao {

	ImageTable getImageDetailsByITID(Long itid) throws Exception;
	void saveImageTable(ImageTable imageTable) throws Exception;
	void imageTableDelete(Long itid) throws Exception;

}
