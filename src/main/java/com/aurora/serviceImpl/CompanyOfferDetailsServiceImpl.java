package com.aurora.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.dao.CompanyOfferDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.CompanyOffers;
import com.aurora.model.CompanyPackageDetails;
import com.aurora.service.CompanyOfferDetailsService;
import com.aurora.util.Constant;
import com.aurora.util.OfferDetailsDTO;
import com.aurora.util.PackageDetailsDTO;

@Service("companyOfferDetailsService")
public class CompanyOfferDetailsServiceImpl implements CompanyOfferDetailsService {
	private CompanyOfferDetailsDao companyOfferDetailsDao = null;
	private CompanyDetailsDao companyDetailsDao = null;
	
	@Autowired
	public void setCompanyOfferDetailsDao(CompanyOfferDetailsDao companyOfferDetailsDao) {
		this.companyOfferDetailsDao = companyOfferDetailsDao;
	}
	@Autowired
	public void setCompanyDetailsDao(CompanyDetailsDao companyDetailsDao) {
		this.companyDetailsDao = companyDetailsDao;
	}
	
	@Transactional
	public String saveCompanyOffer(HttpServletRequest request) {
		String status = Constant.FAIL;
		
		CompanyOffers companyOffers = null;
		CompanyDetails companyDetails = null;
		
		Long codid = null;
		Long compnyId = null;
		
		try {
			
			codid = ServletRequestUtils.getLongParameter(request, "hiddenCODID",0L);
			Boolean isNew = (codid == 0); 
			
			if(isNew) {
				companyOffers = new CompanyOffers();
				status = Constant.SAVED;
			} else {
				companyOffers = companyOfferDetailsDao.getOfferByCODID1(codid);
				status = Constant.UPDATED;
			}
			
			compnyId = ServletRequestUtils.getLongParameter(request, "company",0L);
			companyDetails = companyDetailsDao.getCompanyDetailsBySCDID1(compnyId);
			
			companyOffers.setCompanyDetails(companyDetails);
			companyOffers.setOfferDescription(ServletRequestUtils.getStringParameter(request, "offerDescription"));
			companyOffers.setOfferName(ServletRequestUtils.getStringParameter(request, "offerName"));
			companyOffers.setStatus(ServletRequestUtils.getStringParameter(request, "status"));
			companyOffers.setOfferStartDate(setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "offerStartDate")));
			companyOffers.setOfferEndDate(setStringToDateFormat(ServletRequestUtils.getStringParameter(request, "offerEndDate")));

			companyOfferDetailsDao.saveCompanyOffer(companyOffers);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Transactional
	public List<CompanyOffers> getAllActiveOffers() {
		List<CompanyOffers>  list =null;
		try {
			list = companyOfferDetailsDao.getAllActiveOffers();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	@Transactional
	public OfferDetailsDTO getOfferByCODID(HttpServletRequest request) {
		OfferDetailsDTO  list =null;
		Long codid = ServletRequestUtils.getLongParameter(request, "hiddenCODID",0L);
		try {
			list = companyOfferDetailsDao.getOfferByCODID(codid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	@Transactional
	public String companyOfferDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long codid = ServletRequestUtils.getLongParameter(request, "hiddenCODID",0L);
			companyOfferDetailsDao.companyOfferDelete(codid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}

	@Transactional
	public List<OfferDetailsDTO> getCompanyOfferTable(String sortField,int order, int start, int gridTableSize, String searchq) {
		List<OfferDetailsDTO>  list =null;
		try {
			list = companyOfferDetailsDao.getCompanyOfferTable(sortField,order,start,gridTableSize, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	@Transactional
	public int getCompanyOfferTableCount(String searchq) {
		int count = 0;
		
		try {
			count = companyOfferDetailsDao.getCompanyOfferTableCount(searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	public Date setStringToDateFormat(String date1) throws ParseException{
		
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalFormat.parse(date1);
        Date dateOut = date;
		
        return dateOut;
	}

}
