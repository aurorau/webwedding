package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.CompanyOfferDetailsDao;
import com.aurora.dao.CompanyPackageDetailsDao;
import com.aurora.dao.DistrictDetailsDao;
import com.aurora.dao.FileUploadDao;
import com.aurora.dao.ImageTableDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.dao.SupplierDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.CompanyOffers;
import com.aurora.model.CompanyPackageDetails;
import com.aurora.model.DistrictDetails;
import com.aurora.model.ImageTable;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.CompanyDetailsService;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.CompanyDetailsW2DTO;
import com.aurora.util.Constant;
import com.aurora.util.FileUploadDTO;

@Service("companyDetailsService")
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
	
	private CompanyDetailsDao companyDetailsDao = null;
	private SupplierDetailsDao supplierPersonalDetailDao = null;
	private SupplierCategoryDao supplierCategoryDao = null;
	private DistrictDetailsDao districtDetailsDao = null;
	private FileUploadDao fileUploadDao = null;
	private ImageTableDao imageTableDao = null;
	private CompanyOfferDetailsDao companyOfferDetailsDao = null;
	private CompanyPackageDetailsDao companyPackageDetailsDao = null;
	
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
	
	@Autowired
	public void setFileUploadDao(FileUploadDao fileUploadDao) {
		this.fileUploadDao = fileUploadDao;
	}
	@Autowired
	public void setImageTableDao(ImageTableDao imageTableDao) {
		this.imageTableDao = imageTableDao;
	}
	@Autowired
	public void setCompanyOfferDetailsDao(CompanyOfferDetailsDao companyOfferDetailsDao) {
		this.companyOfferDetailsDao = companyOfferDetailsDao;
	}
	@Autowired
	public void setCompanyPackageDetailsDao(CompanyPackageDetailsDao companyPackageDetailsDao) {
		this.companyPackageDetailsDao = companyPackageDetailsDao;
	}
	
	@Transactional
	public List<CompanyDetailsDTO> getCompanyDetailsTable(String sortField, int order, int start, int length,String searchq) {
		List<CompanyDetailsDTO>  list =null;
		try {
			list = companyDetailsDao.getCompanyDetailsTable(sortField,order,start,length, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public int getCompanyDetailsTableCount(String serchq) {
		int count = 0;
		
		try {
			count = companyDetailsDao.getCompanyDetailsTableCount(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	@Transactional
	public String saveCompanyDetails(MultipartHttpServletRequest request) {
		String status = Constant.FAIL;
		
		CompanyDetails companyDetails = null;
		SupplierPersonalDetails supplierPersonalDetails = null;
		SupplierCategory supplierCategory = null;
		DistrictDetails districtDetails = null;
		ImageTable imageTable = null;
		
		Long scdid = null;
		Long ownerId = null;
		Long categoryId = null;
		Long districtId = null;
		Date companyRegisteredDate = null;
		Date activeDate = null;
		MultipartFile file = null;
		
		try {

			file = request.getFile("file");
			
			scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
			Boolean isNew = (scdid == 0); 
			
			if(isNew) {
				companyDetails = new CompanyDetails();
				imageTable = new ImageTable();
				status = Constant.SAVED;
			} else {
				companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(scdid);
				imageTable = imageTableDao.getImageDetailsByITID(companyDetails.getImageTable().getITID());
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
			companyDetails.setCompanyDescription(ServletRequestUtils.getStringParameter(request, "companyDescription"));
			
			if(file != null) {
				imageTable.setImageContent(file.getBytes());
				imageTable.setImageName(file.getOriginalFilename());
				imageTable.setImageType(file.getContentType());
				imageTable.setImageSize(file.getSize()/1024+"kb");
			}
			
			if(isNew) {
				imageTableDao.saveImageTable(imageTable);
			}
			companyDetails.setImageTable(imageTable);
			companyDetailsDao.saveCompanyDetails(companyDetails);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Transactional
	public Map<String,Object> getCompanyDetailsBySCDID(HttpServletRequest request) {
		CompanyDetailsDTO  companyDetails =null;
		List<CompanyPackageDetails> packageList = null;
		List<CompanyOffers> offerList = null;
		List<FileUploadDTO> list = new ArrayList<FileUploadDTO>();
		List<Long> urlList = new ArrayList<Long>();
		
		Map<String,Object> finalMap = new HashMap<String,Object>();
		
		Long scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
		try {
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID(scdid);
			list = fileUploadDao.getFileDetailsByCompanyId(companyDetails.getSCDID());
			
			for(FileUploadDTO dto : list) {
				if(dto.getUFID() != null){
					urlList.add(dto.getUFID());
				}
			}
			companyDetails.setCompanyImageIds(urlList);
			packageList = getAllActivePackgeListByCompanyId(scdid);
			offerList = getAllActiveOfferByCompanyId(scdid);
			
			finalMap.put("companyDetails", companyDetails);
			finalMap.put("offers", offerList);
			finalMap.put("packages", packageList);
			
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return finalMap;
	}
	@Transactional
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
		
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalFormat.parse(date1);
        Date dateOut = date;
		
        return dateOut;
	}
	@Transactional
	public String companyDetailsDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long scdid = ServletRequestUtils.getLongParameter(request, "hiddenSCDID",0L);
			companyDetailsDao.companyDetailsDelete(scdid);
			Long itid = ServletRequestUtils.getLongParameter(request, "ITID",0L);
			imageTableDao.imageTableDelete(itid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}
	@Transactional
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
	@Transactional
	public List<CompanyDetailsW2DTO> getCompanyDetailsTableW2(String sortField, int order, int start, int gridTableSize,Long serviceCategoryDD, Long districtDD, Long budget) {
		List<CompanyDetailsW2DTO>  list =null;
		List<CompanyDetailsW2DTO>  list1 = new ArrayList<CompanyDetailsW2DTO>();
		
		try {
			list = companyDetailsDao.getCompanyDetailsTableW2(sortField,order,start,gridTableSize,serviceCategoryDD, districtDD, budget);
			if(list.size() > 0 ){
				for(CompanyDetailsW2DTO dto : list) {
					int offersCount = getActiveOfferByCompanyId(dto.getSCDID());
					Long packageCount = (long) getActivePackgeListByCompanyId(dto.getSCDID()).size();
					if(offersCount > 0){
						dto.setOfferAvailable(true);
					} else {
						dto.setOfferAvailable(false);
					}
					if(packageCount > 0){
						dto.setPackageCount(packageCount);
					} else {
						dto.setPackageCount(0L);
					}
					list1.add(dto);
				}
			}
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list1;
	}
	
	public int getActiveOfferByCompanyId(Long companyId){
		int count = companyOfferDetailsDao.getActiveOfferByCompanyId(companyId).size();
		return count;
	}
	
	public List<CompanyOffers> getAllActiveOfferByCompanyId(Long companyId){
		List<CompanyOffers> list = companyOfferDetailsDao.getActiveOfferByCompanyId(companyId);
		return list;
	}
	
	public List<String> getActivePackgeListByCompanyId(Long companyId){
		List<String> packageNamelist = new ArrayList<String>();
		List<CompanyPackageDetails> list = companyPackageDetailsDao.getAllActivePackagesByCompanyId(companyId);
		for(CompanyPackageDetails cdp :list) {
			packageNamelist.add(cdp.getPackageName());
		}
		return packageNamelist;
	}
	public List<CompanyPackageDetails> getAllActivePackgeListByCompanyId(Long companyId){
		List<CompanyPackageDetails> list = companyPackageDetailsDao.getAllActivePackagesByCompanyId(companyId);
		return list;
	}
	
	@Transactional
	public int getCompanyDetailsTableCountW2(Long serviceCategoryDD, Long districtDD, Long budget) {
		int count = 0;
		
		try {
			count = companyDetailsDao.getCompanyDetailsTableCountW2(serviceCategoryDD, districtDD, budget);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	@Transactional
	public List<CompanyDetails> getAllCompanies() {
		List<CompanyDetails>  list =null;
		try {
			list = companyDetailsDao.getAllCompanies();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
}
