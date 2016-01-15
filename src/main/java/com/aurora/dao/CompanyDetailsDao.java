package com.aurora.dao;

import java.util.List;
import com.aurora.model.CompanyDetails;
import com.aurora.util.CompanyDetailsDTO;

public interface CompanyDetailsDao {

	public List<CompanyDetails> getCompanyDetailsTable(String sortField, int order, int start, int length, String searchq) throws Exception;
	public int getCompanyDetailsTableCount(String serchq)throws Exception;
	public void saveCompanyDetails(CompanyDetails companyDetails)throws Exception;
	public CompanyDetailsDTO getCompanyDetailsBySCDID(Long scid)throws Exception;
	public CompanyDetails getCompanyDetailsBySCDID1(Long scid)throws Exception;
	public void companyDetailsDelete(Long scdid);
	public List<CompanyDetails> getAllCompaniesByCategory(Long categoryId);

}
