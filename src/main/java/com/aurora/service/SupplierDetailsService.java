package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.aurora.model.SupplierPersonalDetails;

public interface SupplierDetailsService {
	public List<SupplierPersonalDetails> getSupplierPersonalDetailsable(String sortField,int order,int start, int length, String searchq);
	public int getSupplierPersonalDetailsCount(String serchq);
	public String saveSupplierPersonalDetails(HttpServletRequest request);
	public SupplierPersonalDetails getSupplierPersonalDetailsBySPDID(HttpServletRequest request);
}
