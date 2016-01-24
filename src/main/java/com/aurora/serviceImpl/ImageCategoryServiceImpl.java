package com.aurora.serviceImpl;

import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.dao.ImageCategoryDao;
import com.aurora.dao.ImageTableDao;
import com.aurora.model.ImageCategory;
import com.aurora.model.ImageTable;
import com.aurora.model.SupplierCategory;
import com.aurora.service.ImageCategoryService;
import com.aurora.util.Constant;
import com.aurora.util.ImageCategoryDTO;

@Service("imageCategoryService")
public class ImageCategoryServiceImpl implements ImageCategoryService {
	private ImageCategoryDao imageCategoryDao = null;
	private ImageTableDao imageTableDao = null;
	
	@Autowired
	public void setImageCategoryDao(ImageCategoryDao imageCategoryDao) {
		this.imageCategoryDao = imageCategoryDao;
	}
	
	@Autowired
	public void setImageTableDao(ImageTableDao imageTableDao) {
		this.imageTableDao = imageTableDao;
	}

	@Transactional
	public String saveImageCategory(MultipartHttpServletRequest request) {
		
		String status = Constant.FAIL;
		ImageCategory imageCategory = null;
		ImageTable imageTable = null;
		Long icid = null;
		MultipartFile file = null;
		try {
			
			 
			 file = request.getFile("file");
/*			 
			 System.out.println("File name :"+file.getOriginalFilename());
			 System.out.println("File type :"+file.getContentType());
			 System.out.println("Size :"+file.getSize()/1024+" Kb");
			 
			 System.out.println("Category Type :"+request.getParameter("imageCategoryType"));
			 System.out.println("Category Name :"+request.getParameter("imageCategoryName"));*/

			icid = ServletRequestUtils.getLongParameter(request, "hiddenICID",0L);
			Boolean isNew = (icid == 0); 
			
			if(isNew) {
				imageCategory = new ImageCategory();
				imageTable = new ImageTable();
				status = Constant.SAVED;
			} else {
				imageCategory = imageCategoryDao.getImageCategoryByICID(icid);
				imageTable = imageTableDao.getImageDetailsByITID(imageCategory.getImageTable().getITID());
				status = Constant.UPDATED;
			}
			
			imageCategory.setIcType(ServletRequestUtils.getStringParameter(request, "imageCategoryType"));
			imageCategory.setIcName(ServletRequestUtils.getStringParameter(request, "imageCategoryName"));
			//imageCategory.setIcLogoUrl(ServletRequestUtils.getStringParameter(request, "imageLogoUrl"));
			if(file != null) {
				imageTable.setImageContent(file.getBytes());
				imageTable.setImageName(file.getOriginalFilename());
				imageTable.setImageType(file.getContentType());
				imageTable.setImageSize(file.getSize()/1024+"kb");
			}
			
			if(isNew) {
				imageTableDao.saveImageTable(imageTable);
			}
			
			imageCategory.setImageTable(imageTable);
			
			imageCategoryDao.saveImageCategory(imageCategory);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Transactional
	public List<ImageCategoryDTO> getAllImageCategories() {
		List<ImageCategoryDTO>  list =null;
		try {
			list = imageCategoryDao.getAllImageCategories();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
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
	@Transactional
	public String imageCategoryDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long icid = ServletRequestUtils.getLongParameter(request, "hiddenICID",0L);
			imageCategoryDao.imageCategoryDelete(icid);
			Long itid = ServletRequestUtils.getLongParameter(request, "ITID",0L);
			imageTableDao.imageTableDelete(itid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}
	@Transactional
	public List<ImageCategoryDTO> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq) {
		List<ImageCategoryDTO>  dtoList =null;
		try {
			dtoList = imageCategoryDao.getImageCategoryTable(sortField,order,start,gridTableSize, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return dtoList;
	}
	@Transactional
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
