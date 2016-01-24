package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.model.CompanyDetails;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.CompanyDetailsW2DTO;

public interface CompanyDetailsService {
	public List<CompanyDetailsDTO> getCompanyDetailsTable(String sortField,int order,int start, int length, String searchq);
	public int getCompanyDetailsTableCount(String serchq);
	public String saveCompanyDetails(MultipartHttpServletRequest request);
	public CompanyDetailsDTO getCompanyDetailsBySCDID(HttpServletRequest request);
	public String companyDetailsDelete(HttpServletRequest request);
	public List<CompanyDetails> getAllCompaniesByCategory(HttpServletRequest request);
	public List<CompanyDetailsW2DTO> getCompanyDetailsTableW2(String sortField, int order, int start, int gridTableSize,Long serviceCategoryDD, Long districtDD, Long budget);
	public int getCompanyDetailsTableCountW2(Long serviceCategoryDD, Long districtDD, Long budget);
}
