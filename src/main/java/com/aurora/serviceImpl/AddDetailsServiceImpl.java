package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.dao.AddDetailsDao;
import com.aurora.dao.ImageTableDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.AddDetails;
import com.aurora.model.CompanyDetails;
import com.aurora.model.DistrictDetails;
import com.aurora.model.ImageTable;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.AddDetailsService;
import com.aurora.util.AddDetailsDTO;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.Constant;

@Service("addDetailsService")
public class AddDetailsServiceImpl implements AddDetailsService {
	private AddDetailsDao addDetailsDao = null;
	private ImageTableDao imageTableDao = null;
	//private SupplierCategoryDao supplierCategoryDao = null;
	
	@Autowired
	public void setAddDetailsDao(AddDetailsDao addDetailsDao) {
		this.addDetailsDao = addDetailsDao;
	}
	@Autowired
	public void setImageTableDao(ImageTableDao imageTableDao) {
		this.imageTableDao = imageTableDao;
	}
/*	@Autowired
	public void setSupplierCategoryDao(SupplierCategoryDao supplierCategoryDao) {
		this.supplierCategoryDao = supplierCategoryDao;
	}*/
	@Transactional
	public String saveAddDetails(MultipartHttpServletRequest request) {
		String status = Constant.FAIL;
		
		AddDetails addDetails = null;
		ImageTable imageTable = null;
		//SupplierCategory supplierCategory = null;

		Long aid = null;
		//Long categoryId = null;
		Date addRegisteredDate = null;
		Date activeDate = null;
		MultipartFile file = null;
		try {
			
			file = request.getFile("file");

			aid = ServletRequestUtils.getLongParameter(request, "hiddenAID",0L);
			Boolean isNew = (aid == 0); 
			
			if(isNew) {
				addDetails = new AddDetails();
				imageTable = new ImageTable();
				status = Constant.SAVED;
			} else {
				addDetails = addDetailsDao.getAddDetailsByAID1(aid);
				if(addDetails.getImageTable() == null){
					imageTable = new ImageTable();
				} else {
					imageTable = imageTableDao.getImageDetailsByITID(addDetails.getImageTable().getITID());
				}
				
				status = Constant.UPDATED;
			}
			
			//categoryId = ServletRequestUtils.getLongParameter(request, "supplierCategory",0L);
			
			//supplierCategory = supplierCategoryDao.getSupplierCategoryBySCID(categoryId);
			
			addRegisteredDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "registeredDate"));
			activeDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "activeDate"));
			
			addDetails.setAddSupplierName(ServletRequestUtils.getStringParameter(request, "supplierName"));
			addDetails.setAddSupplierAddress(ServletRequestUtils.getStringParameter(request, "supplierAddress"));
			addDetails.setAddSupplierTp(ServletRequestUtils.getStringParameter(request, "supplierTp"));
			addDetails.setAddSupplierEmail(ServletRequestUtils.getStringParameter(request, "supplierEmail"));
			addDetails.setAddLink(ServletRequestUtils.getStringParameter(request, "addLink"));
			addDetails.setAddDescription(ServletRequestUtils.getStringParameter(request, "addDescription"));
			addDetails.setAddStatus(ServletRequestUtils.getStringParameter(request, "status"));
			addDetails.setAddActivePeriod(ServletRequestUtils.getLongParameter(request, "activePeriod"));
			addDetails.setAddRegisteredDate(addRegisteredDate);
			addDetails.setAddActiveDate(activeDate);
			addDetails.setAddUrl(ServletRequestUtils.getStringParameter(request, "addUrl"));
			
			if(file != null) {
				imageTable.setImageContent(file.getBytes());
				imageTable.setImageName(file.getOriginalFilename());
				imageTable.setImageType(file.getContentType());
				imageTable.setImageSize(file.getSize()/1024+"kb");
			}
			
			if(isNew) {
				imageTableDao.saveImageTable(imageTable);
			}
			addDetails.setImageTable(imageTable);
			addDetailsDao.saveAddDetails(addDetails);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Transactional
	public List<AddDetailsDTO> getAllAdds() {
		List<AddDetailsDTO>  list =null;
		try {
			list = addDetailsDao.getAllAdds();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public AddDetails getAddDetailsByAID(HttpServletRequest request) {
		AddDetails  addDetails =null;
		Long aid = ServletRequestUtils.getLongParameter(request, "hiddenAID",0L);
		try {
			addDetails = addDetailsDao.getAddDetailsByAID1(aid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return addDetails;
	}
	@Transactional
	public String addDetailsDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long aid = ServletRequestUtils.getLongParameter(request, "hiddenAID",0L);
			addDetailsDao.addDetailsDelete(aid);
			Long itid = ServletRequestUtils.getLongParameter(request, "ITID",0L);
			imageTableDao.imageTableDelete(itid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}
	@Transactional
	public List<AddDetailsDTO> getAddDetailTable(String sortField, int order, int start, int gridTableSize,String searchq) {
		List<AddDetailsDTO>  list =null;
		List<AddDetailsDTO>  list1 =new ArrayList<AddDetailsDTO>();
		try {
			list = addDetailsDao.getAddDetailTable(sortField,order,start,gridTableSize, searchq);
			
			for(AddDetailsDTO lst  : list) {
				if(lst.getITID() == null){
					lst.setITID(0L);
				}
				list1.add(lst);
			}
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list1;
	}
	@Transactional
	public int getAddDetailTableCount(String searchq) {
		int count = 0;
		
		try {
			count = addDetailsDao.getAddDetailTableCount(searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	@Transactional
	public Date setStringToDateFormat(String date1) throws ParseException{
		
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalFormat.parse(date1);
        Date dateOut = date;
		
        return dateOut;
	}
	public String saveAddDetailsW2(HttpServletRequest request) {
		String status = Constant.FAIL;
		
		AddDetails addDetails = null;

		Long aid = null;
		Date addRegisteredDate = null;
		Date activeDate = null;
		MultipartFile file = null;
		try {
			addDetails = new AddDetails();
			status = Constant.SAVED;
			
			addRegisteredDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "registeredDate"));
			activeDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "activeDate"));
			
			addDetails.setAddSupplierName(ServletRequestUtils.getStringParameter(request, "supplierName"));
			addDetails.setAddSupplierAddress(ServletRequestUtils.getStringParameter(request, "supplierAddress"));
			addDetails.setAddSupplierTp(ServletRequestUtils.getStringParameter(request, "supplierTp"));
			addDetails.setAddSupplierEmail(ServletRequestUtils.getStringParameter(request, "supplierEmail"));
			addDetails.setAddLink(ServletRequestUtils.getStringParameter(request, "addLink"));
			addDetails.setAddDescription(ServletRequestUtils.getStringParameter(request, "addDescription"));
			addDetails.setAddStatus(ServletRequestUtils.getStringParameter(request, "status"));
			addDetails.setAddActivePeriod(ServletRequestUtils.getLongParameter(request, "activePeriod"));
			addDetails.setAddRegisteredDate(addRegisteredDate);
			addDetails.setAddActiveDate(activeDate);
			addDetails.setAddUrl(ServletRequestUtils.getStringParameter(request, "addUrl"));
			
			addDetailsDao.saveAddDetails(addDetails);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
