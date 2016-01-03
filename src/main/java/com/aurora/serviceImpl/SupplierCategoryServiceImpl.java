package com.aurora.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.DistrictDetailsDao;
import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.service.SupplierCategoryService;
import com.aurora.util.Constant;

@Service("supplierCategoryService")
public class SupplierCategoryServiceImpl implements SupplierCategoryService {

	private SupplierCategoryDao supplierCategoryDao = null;
	
	@Autowired
	public void setDistrictDetailsDao(SupplierCategoryDao supplierCategoryDao) {
		this.supplierCategoryDao = supplierCategoryDao;
	}
	
	public List<SupplierCategory> getSupplierCategoryTable(String serchq) {
		return null;
	}

	public int getSupplierCategoryTableCount(String serchq) {
		return 0;
	}

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

}
