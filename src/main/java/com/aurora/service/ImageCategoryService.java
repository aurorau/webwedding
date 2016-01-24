package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.model.ImageCategory;
import com.aurora.util.ImageCategoryDTO;

public interface ImageCategoryService {

	String saveImageCategory(MultipartHttpServletRequest request);
	List<ImageCategoryDTO> getAllImageCategories();
	ImageCategory getImageCategoryByICID(HttpServletRequest request);
	String imageCategoryDelete(HttpServletRequest request);
	List<ImageCategoryDTO> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq);
	int getImageCategoryTableCount(String searchq);
}
