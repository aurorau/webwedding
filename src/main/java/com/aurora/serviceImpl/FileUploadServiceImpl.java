package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.FileUploadDao;
import com.aurora.dao.ImageCategoryDao;
import com.aurora.dao.ImageTableDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.ImageCategory;
import com.aurora.model.UploadFiles;
import com.aurora.service.FileUploadService;
import com.aurora.util.Constant;
import com.aurora.util.FileUploadDTO;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

	private FileUploadDao fileUploadDao = null;
	private SupplierCategoryDao supplierCategoryDao = null;
	private CompanyDetailsDao companyDetailsDao = null;
	private ImageCategoryDao imageCategoryDao = null;
	private ImageTableDao imageTableDao = null;
	
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
	@Autowired
	public void setImageCategoryDao(ImageCategoryDao imageCategoryDao) {
		this.imageCategoryDao = imageCategoryDao;
	}
	@Autowired
	public void setImageTableDao(ImageTableDao imageTableDao) {
		this.imageTableDao = imageTableDao;
	}
	@Transactional
	public String saveFile(MultipartHttpServletRequest request) {
		
		String status = Constant.FAIL;
		
		CompanyDetails companyDetails = null;
		UploadFiles uploadFiles = null;
		ImageCategory imageCategory = null;
		
		Long fuid = null;
		Long companyId = null;
		Long fileImageCategoryId = null;
		Date fileUploadDate = null;
		MultipartFile file = null;
		
/*		String[] images  = request.getParameterValues("ar");
		String[] imgList = null;
		
		String convertList = images[0];
		imgList = convertList.split(",");*/
		
		
		try {
			
			 file = request.getFile("file");
			
			//fuid = ServletRequestUtils.getLongParameter(request, "hiddenUFID",0L);
			//Boolean isNew = (fuid == 0); 
			
			//uploadFiles = fileUploadDao.getFileDetailsByName(imgList[0]);
			
			//if(uploadFiles == null) {
/*				if(isNew) {
					uploadFiles = new UploadFiles();
					status = Constant.SAVED;
				} else {
					uploadFiles = fileUploadDao.getFileDetailsByFUID(fuid);
					status = Constant.UPDATED;
				}*/

				uploadFiles = new UploadFiles();
			
				companyId = ServletRequestUtils.getLongParameter(request, "fileCompanyId",0L);
				fileImageCategoryId = ServletRequestUtils.getLongParameter(request, "fileImageCategoryId",0L);
				fileUploadDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "fileUploadDateId"));
				
				companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(companyId);
				imageCategory = imageCategoryDao.getImageCategoryByICID(fileImageCategoryId);
				
				//if(file != null) {
					uploadFiles.setImageContent(file.getBytes());
					uploadFiles.setImageName(file.getOriginalFilename());
					uploadFiles.setImageType(file.getContentType());
					uploadFiles.setImageSize(file.getSize()/1024+"kb");
				//}
				uploadFiles.setFileUploadDate(fileUploadDate);
				uploadFiles.setImageCategory(imageCategory);
				uploadFiles.setSupplierCompanyDetails(companyDetails);
				fileUploadDao.saveFile(uploadFiles);
/*				for(String imgUrl : imgList) {
					uploadFiles.setFileType(ServletRequestUtils.getStringParameter(request, "fileTypeId"));
					uploadFiles.setFileUrl(imgUrl);
					uploadFiles.setSupplierCategory(supplierCategory);
					uploadFiles.setImageCategory(imageCategory);
					uploadFiles.setSupplierCompanyDetails(companyDetails);
					uploadFiles.setFileUploadDate(fileUploadDate);
					
					fileUploadDao.saveFile(uploadFiles);
				}*/
/*			} else {
				status = Constant.EXIST;
			}*/

			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

	public Date setStringToDateFormat(String date1) throws ParseException{
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalFormat.parse(date1);
        Date dateOut = date;
        return dateOut;
	}
	@Transactional
	public List<FileUploadDTO> getFileDetailsTable(String sortField, int order, int start, int gridTableSize,Long caterogyId, Long companyId,Long fileImageCategoryId, String searchq) {
		List<FileUploadDTO>  list =null;
		try {
			list = fileUploadDao.getFileDetailsTable(sortField,order,start,gridTableSize,caterogyId,companyId,fileImageCategoryId, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public int getFileDetailsTableCount(Long caterogyId, Long companyId,Long fileImageCategoryId, String searchq) {
		int count = 0;
		
		try {
			count = fileUploadDao.getFileDetailsTableCount(caterogyId,companyId,fileImageCategoryId,searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	@Transactional
	public String deleteImage(long parseLong) {
		String status = Constant.FAIL;
		try {
			status = Constant.SUCCESS;
			fileUploadDao.deleteImage(parseLong);
		}catch(Exception e){
			System.out.println("Delete image error:"+e);
		}
		return status;
	}
	@Transactional
	public List<FileUploadDTO> getImagesByImageCategoryId(Long fileImageCategoryId) {
		List<FileUploadDTO>  list =null;
		try {
			list = fileUploadDao.getImagesByImageCategoryId(fileImageCategoryId);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public UploadFiles getFileByUFID(Long ufid) {
		UploadFiles  uf =null;
		try {
			uf = fileUploadDao.getFileByUFID(ufid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return uf;
	}
}
