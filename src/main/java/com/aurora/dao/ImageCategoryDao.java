package com.aurora.dao;

import java.util.List;

import com.aurora.model.ImageCategory;
import com.aurora.util.ImageCategoryDTO;

public interface ImageCategoryDao {

	ImageCategory getImageCategoryByICID(Long icid);
	void saveImageCategory(ImageCategory imageCategory);
	List<ImageCategoryDTO> getAllImageCategories();
	void imageCategoryDelete(Long icid);
	List<ImageCategoryDTO> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq);
	int getImageCategoryTableCount(String searchq);

}
