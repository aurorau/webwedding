package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.DistrictDetailsDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.dao.SupplierDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.CompanyDetailsService;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.Constant;

@Service("companyDetailsService")
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
	
	private CompanyDetailsDao companyDetailsDao = null;
	private SupplierDetailsDao supplierPersonalDetailDao = null;
	private SupplierCategoryDao supplierCategoryDao = null;
	private DistrictDetailsDao districtDetailsDao = null;
	
	@Autowired
	public void setCompanyDetailsDao(CompanyDetailsDao companyDetailsDao) {
		this.companyDetailsDao = companyDetailsDao;
	}
	
	@Autowired
	public void setCompanySupplierDetailsDao(SupplierDetailsDao supplierPersonalDetailDao) {
		this.supplierPersonalDetailDao = supplierPersonalDetailDao;
	}
	
	@Autowired
	public void setSupplierCategoryDao(SupplierCategoryDao supplierCategoryDao) {
		this.supplierCategoryDao = supplierCategoryDao;
	}
	
	@Autowired
	public void setDistrictDetailsDao(DistrictDetailsDao districtDetailsDao) {
		this.districtDetailsDao = districtDetailsDao;
	}

	public List<CompanyDetails> getCompanyDetailsTable(String sortField, int order, int start, int length,String searchq) {
		List<CompanyDetails>  list =null;
		try {
			list = companyDetailsDao.getCompanyDetailsTable(sortField,order,start,length, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public int getCompanyDetailsTableCount(String serchq) {
		int count = 0;
		
		try {
			count = companyDetailsDao.getCompanyDetailsTableCount(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}

	public String saveCompanyDetails(HttpServletRequest request) {
		String status = null;
		
		CompanyDetails companyDetails = null;
		SupplierPersonalDetails supplierPersonalDetails = null;
		SupplierCategory supplierCategory = null;
		DistrictDetails districtDetails = null;
		
		Long scdid = null;
		Long ownerId = null;
		Long categoryId = null;
		Long districtId = null;
		Date companyRegisteredDate = null;
		Date activeDate = null;
		
		try {

			scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
			Boolean isNew = (scdid == 0); 
			
			if(isNew) {
				companyDetails = new CompanyDetails();
				status = Constant.SAVED;
			} else {
				companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(scdid);
				status = Constant.UPDATED;
			}
			
			ownerId = ServletRequestUtils.getLongParameter(request, "supplierPersonalDetails",0L);
			categoryId = ServletRequestUtils.getLongParameter(request, "supplierCategory",0L);
			districtId = ServletRequestUtils.getLongParameter(request, "districtDetails",0L);
			
			supplierPersonalDetails = supplierPersonalDetailDao.getSupplierPersonalDetailsBySPDID(ownerId);
			supplierCategory = supplierCategoryDao.getSupplierCategoryBySCID(categoryId);
			districtDetails = districtDetailsDao.getDistrictDetailsByDDID(districtId);
			
			companyRegisteredDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "companyRegisteredDate"));
			activeDate = setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "activeDate"));
			
			companyDetails.setSupplierPersonalDetails(supplierPersonalDetails);
			companyDetails.setSupplierCategory(supplierCategory);
			companyDetails.setDistrictDetails(districtDetails);
			companyDetails.setCompanyName(ServletRequestUtils.getStringParameter(request, "companyName"));
			companyDetails.setCompanyAddress(ServletRequestUtils.getStringParameter(request, "companyAddress"));
			companyDetails.setCompanyTp1(ServletRequestUtils.getStringParameter(request, "companyTp1"));
			companyDetails.setCompanyTp2(ServletRequestUtils.getStringParameter(request, "companyTp2"));
			companyDetails.setCompanyEmail(ServletRequestUtils.getStringParameter(request, "companyEmail"));
			companyDetails.setCompanyFaxNo(ServletRequestUtils.getStringParameter(request, "companyFaxNo"));
			companyDetails.setCompanyWebURl(ServletRequestUtils.getStringParameter(request, "companyWebURl"));
			companyDetails.setCompanyFbPage(ServletRequestUtils.getStringParameter(request, "companyFbPage"));
			companyDetails.setBudget(ServletRequestUtils.getLongParameter(request, "budget"));
			companyDetails.setStatus(ServletRequestUtils.getStringParameter(request, "status"));
			companyDetails.setCompanyRegistrationNumber(ServletRequestUtils.getStringParameter(request, "companyRegistrationNumber"));
			companyDetails.setActivePeriod(ServletRequestUtils.getLongParameter(request, "activePeriod"));
			companyDetails.setCompanyRegisteredDate(companyRegisteredDate);
			companyDetails.setActiveDate(activeDate);
			
			companyDetailsDao.saveCompanyDetails(companyDetails);
			
		}catch(Exception e) {
			status = Constant.FAIL;
			System.out.println(e);
		}
		return status;
	}

	public CompanyDetailsDTO getCompanyDetailsBySCDID(HttpServletRequest request) {
		CompanyDetailsDTO  companyDetails =null;
		Long scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
		try {
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID(scdid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return companyDetails;
	}
	
	public CompanyDetails getCompanyDetailsBySCDID1(Long scdid) {
		CompanyDetails  companyDetails =null;
		try {
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(scdid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return companyDetails;
	}
	
	public Date setStringToDateFormat(String date1) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
       // DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date date = originalFormat.parse(date1);
        //String formattedDate = targetFormat.format(date); 
        //System.out.println(formattedDate);
        Date dateOut = date;
        	//dt.parse(formattedDate);
		
        return dateOut;
	}

	public String companyDetailsDelete(HttpServletRequest request) {
		String status = null;
		try {
			Long scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
			companyDetailsDao.companyDetailsDelete(scdid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			status = Constant.FAIL;
			System.out.println("Error :"+e);
		}
		return status;
	}

	public List<CompanyDetails> getAllCompaniesByCategory(HttpServletRequest request) {
		List<CompanyDetails>  list =null;
		Long categoryId = ServletRequestUtils.getLongParameter(request, "fileCategoryId",0L);
		try {
			list = companyDetailsDao.getAllCompaniesByCategory(categoryId);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
}
