package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.ImageCategory;

public interface ImageCategoryService {

	String saveImageCategory(HttpServletRequest request);
	List<ImageCategory> getAllImageCategories();
	ImageCategory getImageCategoryByICID(HttpServletRequest request);
	String imageCategoryDelete(HttpServletRequest request);
	List<ImageCategory> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq);
	int getImageCategoryTableCount(String searchq);
}
