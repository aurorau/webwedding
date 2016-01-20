package com.aurora.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.ImageCategoryDao;
import com.aurora.model.ImageCategory;
import com.aurora.model.SupplierCategory;
import com.aurora.service.ImageCategoryService;
import com.aurora.util.Constant;

@Service("imageCategoryService")
public class ImageCategoryServiceImpl implements ImageCategoryService {
	private ImageCategoryDao imageCategoryDao = null;
	
	@Autowired
	public void setImageCategoryDao(ImageCategoryDao imageCategoryDao) {
		this.imageCategoryDao = imageCategoryDao;
	}

	public String saveImageCategory(HttpServletRequest request) {
		String status = Constant.FAIL;
		ImageCategory imageCategory = null;
		Long icid = null;
		try {

			icid = ServletRequestUtils.getLongParameter(request, "hiddenICID",0L);
			Boolean isNew = (icid == 0); 
			
			if(isNew) {
				imageCategory = new ImageCategory();
				status = Constant.SAVED;
			} else {
				imageCategory = imageCategoryDao.getImageCategoryByICID(icid);
				status = Constant.UPDATED;
			}
			
			imageCategory.setIcType(ServletRequestUtils.getStringParameter(request, "imageCategoryType"));
			imageCategory.setIcName(ServletRequestUtils.getStringParameter(request, "imageCategoryName"));
			imageCategory.setIcLogoUrl(ServletRequestUtils.getStringParameter(request, "imageLogoUrl"));
			
			imageCategoryDao.saveImageCategory(imageCategory);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public List<ImageCategory> getAllImageCategories() {
		List<ImageCategory>  list =null;
		try {
			list = imageCategoryDao.getAllImageCategories();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public ImageCategory getImageCategoryByICID(HttpServletRequest request) {
		ImageCategory  imageCategory =null;
		Long icid = ServletRequestUtils.getLongParameter(request, "hiddenICID",0L);
		try {
			imageCategory = imageCategoryDao.getImageCategoryByICID(icid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return imageCategory;
	}

	public String imageCategoryDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long icid = ServletRequestUtils.getLongParameter(request, "hiddenICID",0L);
			imageCategoryDao.imageCategoryDelete(icid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}

	public List<ImageCategory> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq) {
		List<ImageCategory>  list =null;
		try {
			list = imageCategoryDao.getImageCategoryTable(sortField,order,start,gridTableSize, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public int getImageCategoryTableCount(String searchq) {
		int count = 0;
		
		try {
			count = imageCategoryDao.getImageCategoryTableCount(searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
}
