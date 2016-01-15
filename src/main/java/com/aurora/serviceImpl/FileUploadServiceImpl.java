package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.DistrictDetailsDao;
import com.aurora.dao.FileUploadDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.model.UploadFiles;
import com.aurora.service.FileUploadService;
import com.aurora.util.Constant;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

	private FileUploadDao fileUploadDao = null;
	private SupplierCategoryDao supplierCategoryDao = null;
	private CompanyDetailsDao companyDetailsDao = null;
	
	@Autowired
	public void setFileUploadDao(FileUploadDao fileUploadDao) {
		this.fileUploadDao = fileUploadDao;
	}
	@Autowired
	public void setSupplierCategoryDao(SupplierCategoryDao supplierCategoryDao) {
		this.supplierCategoryDao = supplierCategoryDao;
	}
	@Autowired
	public void setCompanyDetailsDao(CompanyDetailsDao companyDetailsDao) {
		this.companyDetailsDao = companyDetailsDao;
	}
	
	public String saveFile(HttpServletRequest request) {
		
		String status = null;
		
		CompanyDetails companyDetails = null;
		SupplierCategory supplierCategory = null;
		UploadFiles uploadFiles = null;
		
		Long fuid = null;
		Long companyId = null;
		Long categoryId = null;
		Date fileUploadDate = null;
		
		String[] images  = request.getParameterValues("ar");
		String[] imgList = null;
		
		String convertList = images[0];
		imgList = convertList.split(",");
		
		
		try {
			fuid = ServletRequestUtils.getLongParameter(request, "hiddenUFID",0L);
			Boolean isNew = (fuid == 0); 
			
			if(isNew) {
				uploadFiles = new UploadFiles();
				status = Constant.SAVED;
			} else {
				uploadFiles = fileUploadDao.getFileDetailsByFUID(fuid);
				status = Constant.UPDATED;
			}

			companyId = ServletRequestUtils.getLongParameter(request, "fileCompanyId",0L);
			categoryId = ServletRequestUtils.getLongParameter(request, "fileCategoryId",0L);
			fileUploadDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "fileUploadDateId"));
			
			supplierCategory = supplierCategoryDao.getSupplierCategoryBySCID(categoryId);
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(companyId);
			
			
			for(String imgUrl : imgList) {
				uploadFiles.setFileType(ServletRequestUtils.getStringParameter(request, "fileTypeId"));
				uploadFiles.setFileUrl(imgUrl);
				uploadFiles.setSupplierCategory(supplierCategory);
				uploadFiles.setSupplierCompanyDetails(companyDetails);
				uploadFiles.setFileUploadDate(fileUploadDate);
				
				fileUploadDao.saveFile(uploadFiles);
			}
			
		}catch(Exception e) {
			status = Constant.FAIL;
			System.out.println(e);
		}
		
		return status;
	}

	public Date setStringToDateFormat(String date1) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date date = originalFormat.parse(date1);
        Date dateOut = date;
		
        return dateOut;
	}
	public List<UploadFiles> getFileDetailsTable(String sortField, int order, int start, int gridTableSize,Long caterogyId, Long companyId, String searchq) {
		List<UploadFiles>  list =null;
		try {
			list = fileUploadDao.getFileDetailsTable(sortField,order,start,gridTableSize,caterogyId,companyId, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	public int getFileDetailsTableCount(Long caterogyId, Long companyId, String searchq) {
		int count = 0;
		
		try {
			count = fileUploadDao.getFileDetailsTableCount(caterogyId,companyId,searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	public String deleteImage(long parseLong) {
		String status = null;
		try {
			fileUploadDao.deleteImage(parseLong);
			status = Constant.SUCCESS;
		}catch(Exception e){
			status = Constant.FAIL;
			System.out.println("Delete image error:"+e);
		}
		return status;
	}
}
