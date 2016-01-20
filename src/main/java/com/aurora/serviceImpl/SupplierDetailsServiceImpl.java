package com.aurora.serviceImpl;

import java.util.List;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.SupplierCategoryDao;
import com.aurora.dao.SupplierDetailsDao;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.SupplierDetailsService;
import com.aurora.util.Constant;

@Service("SupplierDetailsService")
public class SupplierDetailsServiceImpl implements SupplierDetailsService {

	private SupplierDetailsDao supplierDetailsDao = null;
	
	@Autowired
	public void setSupplierDetailsDao(SupplierDetailsDao supplierDetailsDao) {
		this.supplierDetailsDao = supplierDetailsDao;
	}
	
	public List<SupplierPersonalDetails> getSupplierPersonalDetailsable(String sortField, int order, int start,int length, String searchq) {
		List<SupplierPersonalDetails>  list =null;
		try {
			list = supplierDetailsDao.getSupplierPersonalDetailsable(sortField,order,start,length, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public int getSupplierPersonalDetailsCount(String serchq) {
		int count = 0;
		
		try {
			count = supplierDetailsDao.getSupplierPersonalDetailsCount(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}

	public String saveSupplierPersonalDetails(HttpServletRequest request) {
		String status = null;
		SupplierPersonalDetails supplierPersonalDetails = null;
		Long spdid = null;
		try {

			spdid = ServletRequestUtils.getLongParameter(request, "hiddenSPDID",0L);
			Boolean isNew = (spdid == 0); 
			
			if(isNew) {
				supplierPersonalDetails = new SupplierPersonalDetails();
				status = Constant.SAVED;
			} else {
				supplierPersonalDetails = supplierDetailsDao.getSupplierPersonalDetailsBySPDID(spdid);
				status = Constant.UPDATED;
			}
			
			supplierPersonalDetails.setSupplierFirstName(ServletRequestUtils.getStringParameter(request, "fname"));
			supplierPersonalDetails.setSupplierLastName(ServletRequestUtils.getStringParameter(request, "lname"));
			supplierPersonalDetails.setSupplierTp1(ServletRequestUtils.getStringParameter(request, "tp1"));
			supplierPersonalDetails.setSupplierTp2(ServletRequestUtils.getStringParameter(request, "tp2"));
			supplierPersonalDetails.setSupplierEmail(ServletRequestUtils.getStringParameter(request, "email"));
			supplierPersonalDetails.setSupplierSkypeAddress(ServletRequestUtils.getStringParameter(request, "skype"));
			supplierPersonalDetails.setSupplierType(ServletRequestUtils.getStringParameter(request, "type"));
			supplierPersonalDetails.setStatus(ServletRequestUtils.getStringParameter(request, "status"));
			supplierPersonalDetails.setDescription(ServletRequestUtils.getStringParameter(request, "description"));
			
			supplierDetailsDao.saveSupplierPersonalDetails(supplierPersonalDetails);
			
		}catch(Exception e) {
			status = Constant.FAIL;
			System.out.println(e);
		}
		return status;
	}

	public SupplierPersonalDetails getSupplierPersonalDetailsBySPDID(HttpServletRequest request) {
		SupplierPersonalDetails  supplierPersonalDetails =null;
		Long spdid = ServletRequestUtils.getLongParameter(request, "hiddenSPDID",0L);
		try {
			supplierPersonalDetails = supplierDetailsDao.getSupplierPersonalDetailsBySPDID(spdid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return supplierPersonalDetails;
	}

	public List<SupplierPersonalDetails> getAllSuppliers() {
		List<SupplierPersonalDetails>  list =null;
		try {
			list = supplierDetailsDao.getAllSuppliers();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public String supplierDetailsDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long spdid = ServletRequestUtils.getLongParameter(request, "hiddenSPDID",0L);
			supplierDetailsDao.supplierDetailsDelete(spdid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}

}
