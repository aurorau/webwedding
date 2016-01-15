package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;

public interface SupplierCategoryService {
	public List<SupplierCategory> getSupplierCategoryTable(String sortField,int order,int start, int length, String searchq);
	public int getSupplierCategoryTableCount(String serchq);
	public String saveSupplierCategory(HttpServletRequest request);
	public SupplierCategory getSupplierCategoryBySCID(HttpServletRequest request);
	public List<SupplierCategory> getAllCategories();
}
