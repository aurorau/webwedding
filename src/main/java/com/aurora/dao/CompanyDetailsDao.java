package com.aurora.dao;

import java.util.List;
import com.aurora.model.CompanyDetails;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.CompanyDetailsW2DTO;

public interface CompanyDetailsDao {

	public List<CompanyDetailsDTO> getCompanyDetailsTable(String sortField, int order, int start, int length, String searchq) throws Exception;
	public int getCompanyDetailsTableCount(String serchq)throws Exception;
	public void saveCompanyDetails(CompanyDetails companyDetails)throws Exception;
	public CompanyDetailsDTO getCompanyDetailsBySCDID(Long scid)throws Exception;
	public CompanyDetails getCompanyDetailsBySCDID1(Long scid)throws Exception;
	public void companyDetailsDelete(Long scdid) throws Exception;
	public List<CompanyDetails> getAllCompaniesByCategory(Long categoryId);
	public List<CompanyDetailsW2DTO> getCompanyDetailsTableW2(String sortField, int order, int start, int gridTableSize,Long serviceCategoryDD, Long districtDD, Long budget);
	public int getCompanyDetailsTableCountW2(Long serviceCategoryDD, Long districtDD, Long budget);

}
