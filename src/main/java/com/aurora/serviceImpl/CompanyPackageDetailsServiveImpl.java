package com.aurora.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.CompanyPackageDetailsDao;
import com.aurora.dao.ImageTableDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.CompanyPackageDetails;
import com.aurora.model.DistrictDetails;
import com.aurora.model.ImageTable;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.CompanyPackageDetailsService;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.Constant;
import com.aurora.util.PackageDetailsDTO;

@Service("companyPackageDetailsService")
public class CompanyPackageDetailsServiveImpl implements CompanyPackageDetailsService {

	private CompanyPackageDetailsDao companyPackageDetailsDao = null;
	private CompanyDetailsDao companyDetailsDao = null;
	
	@Autowired
	public void setCompanyPackageDetailsDao(CompanyPackageDetailsDao companyPackageDetailsDao) {
		this.companyPackageDetailsDao = companyPackageDetailsDao;
	}
	@Autowired
	public void setCompanyDetailsDao(CompanyDetailsDao companyDetailsDao) {
		this.companyDetailsDao = companyDetailsDao;
	}
	
	@Transactional
	public String saveCompanyPackage(HttpServletRequest request) {
		String status = Constant.FAIL;
		
		CompanyPackageDetails companyPackageDetails = null;
		CompanyDetails companyDetails = null;
		
		Long cpdid = null;
		Long compnyId = null;
		
		try {
			
			cpdid = ServletRequestUtils.getLongParameter(request, "hiddenCPDID",0L);
			Boolean isNew = (cpdid == 0); 
			
			if(isNew) {
				companyPackageDetails = new CompanyPackageDetails();
				status = Constant.SAVED;
			} else {
				companyPackageDetails = companyPackageDetailsDao.getPackageByCPDID1(cpdid);
				status = Constant.UPDATED;
			}
			
			compnyId = ServletRequestUtils.getLongParameter(request, "company",0L);
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(compnyId);
			
			companyPackageDetails.setCompanyDetails(companyDetails);
			companyPackageDetails.setPackageDescription(ServletRequestUtils.getStringParameter(request, "packageDescription"));
			companyPackageDetails.setPackageName(ServletRequestUtils.getStringParameter(request, "packageName"));
			companyPackageDetails.setStatus(ServletRequestUtils.getStringParameter(request, "status"));

			companyPackageDetailsDao.saveCompanyPackage(companyPackageDetails);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Transactional
	public List<CompanyPackageDetails> getAllActivePackages() {
		List<CompanyPackageDetails>  list =null;
		try {
			list = companyPackageDetailsDao.getAllActivePackages();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	
	@Transactional
	public PackageDetailsDTO getPackageByCPDID(HttpServletRequest request) {
		PackageDetailsDTO  list =null;
		Long cpdid = ServletRequestUtils.getLongParameter(request, "hiddenCPDID",0L);
		try {
			list = companyPackageDetailsDao.getPackageByCPDID(cpdid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	@Transactional
	public String companyPackageDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long cpdid = ServletRequestUtils.getLongParameter(request, "hiddenCPDID",0L);
			companyPackageDetailsDao.companyPackageDelete(cpdid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}

	@Transactional
	public List<PackageDetailsDTO> getCompanyPackageTable(String sortField,int order, int start, int gridTableSize, String searchq) {
		List<PackageDetailsDTO>  list =null;
		try {
			list = companyPackageDetailsDao.getCompanyPackageTable(sortField,order,start,gridTableSize, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	@Transactional
	public int getCompanyPackageTableCount(String searchq) {
		int count = 0;
		
		try {
			count = companyPackageDetailsDao.getCompanyPackageTableCount(searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}

}
