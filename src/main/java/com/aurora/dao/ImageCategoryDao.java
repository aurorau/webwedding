package com.aurora.dao;

import java.util.List;

import com.aurora.model.ImageCategory;

public interface ImageCategoryDao {

	ImageCategory getImageCategoryByICID(Long icid);
	void saveImageCategory(ImageCategory imageCategory);
	List<ImageCategory> getAllImageCategories();
	void imageCategoryDelete(Long icid);
	List<ImageCategory> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq);
	int getImageCategoryTableCount(String searchq);

}
