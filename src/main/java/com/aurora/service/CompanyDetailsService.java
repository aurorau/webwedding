package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.aurora.model.CompanyDetails;
import com.aurora.util.CompanyDetailsDTO;

public interface CompanyDetailsService {
	public List<CompanyDetails> getCompanyDetailsTable(String sortField,int order,int start, int length, String searchq);
	public int getCompanyDetailsTableCount(String serchq);
	public String saveCompanyDetails(HttpServletRequest request);
	public CompanyDetailsDTO getCompanyDetailsBySCDID(HttpServletRequest request);
	public String companyDetailsDelete(HttpServletRequest request);
	public List<CompanyDetails> getAllCompaniesByCategory(HttpServletRequest request);
}
