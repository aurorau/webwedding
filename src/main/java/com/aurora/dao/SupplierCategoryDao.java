package com.aurora.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;

public interface SupplierCategoryDao {
	public List<SupplierCategory> getSupplierCategoryTable(String sortField,int order,int start, int length, String searchq)throws Exception;
	public int getSupplierCategoryTableCount(String serchq)throws Exception;
	public void saveSupplierCategory(SupplierCategory supplierCategory)throws Exception;
	public SupplierCategory getSupplierCategoryBySCID(Long scid) throws Exception;
	public List<SupplierCategory> getAllSuppliers();
	public void supplierCategoryDelete(Long scid) throws Exception;
}
