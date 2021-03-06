package com.aurora.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.DistrictDetailsDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.SupplierCategoryService;
import com.aurora.util.Constant;

@Service("supplierCategoryService")
public class SupplierCategoryServiceImpl implements SupplierCategoryService {

	private SupplierCategoryDao supplierCategoryDao = null;
	
	@Autowired
	public void setDistrictDetailsDao(SupplierCategoryDao supplierCategoryDao) {
		this.supplierCategoryDao = supplierCategoryDao;
	}
	@Transactional
	public List<SupplierCategory> getSupplierCategoryTable(String sortField,int order,int start, int length, String searchq) {
		List<SupplierCategory>  list =null;
		try {
			list = supplierCategoryDao.getSupplierCategoryTable(sortField,order,start,length, searchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public int getSupplierCategoryTableCount(String serchq) {
		int count = 0;
		
		try {
			count = supplierCategoryDao.getSupplierCategoryTableCount(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}
	@Transactional
	public String saveSupplierCategory(HttpServletRequest request) {
		String status = null;
		SupplierCategory supplierCategory = null;
		Long scid = null;
		try {

			scid = ServletRequestUtils.getLongParameter(request, "hiddenSCID",0L);
			Boolean isNew = (scid == 0); 
			
			if(isNew) {
				supplierCategory = new SupplierCategory();
				status = Constant.SAVED;
			} else {
				supplierCategory = supplierCategoryDao.getSupplierCategoryBySCID(scid);
				status = Constant.UPDATED;
			}
			
			supplierCategory.setScType(ServletRequestUtils.getStringParameter(request, "supplierCategoryType"));
			supplierCategory.setScName(ServletRequestUtils.getStringParameter(request, "supplierCategoryName"));
			
			supplierCategoryDao.saveSupplierCategory(supplierCategory);
			
		}catch(Exception e) {
			status = Constant.FAIL;
			System.out.println(e);
		}
		return status;
	}
	@Transactional
	public SupplierCategory getSupplierCategoryBySCID(HttpServletRequest request) {
		SupplierCategory  supplierCategory =null;
		Long scid = ServletRequestUtils.getLongParameter(request, "hiddenSCID",0L);
		try {
			supplierCategory = supplierCategoryDao.getSupplierCategoryBySCID(scid);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return supplierCategory;
	}
	@Transactional
	public List<SupplierCategory> getAllCategories() {
		List<SupplierCategory>  list =null;
		try {
			list = supplierCategoryDao.getAllSuppliers();
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}
	@Transactional
	public String supplierCategoryDelete(HttpServletRequest request) {
		String status = Constant.FAIL;
		try {
			Long scid = ServletRequestUtils.getLongParameter(request, "hiddenSCID",0L);
			supplierCategoryDao.supplierCategoryDelete(scid);
			status = Constant.SUCCESS;
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return status;
	}

}
