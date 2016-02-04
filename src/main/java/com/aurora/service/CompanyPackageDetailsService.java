package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.CompanyPackageDetails;
import com.aurora.util.PackageDetailsDTO;

public interface CompanyPackageDetailsService {

	String saveCompanyPackage(HttpServletRequest request);
	List<CompanyPackageDetails> getAllActivePackages();
	PackageDetailsDTO getPackageByCPDID(HttpServletRequest request);
	String companyPackageDelete(HttpServletRequest request);
	List<PackageDetailsDTO> getCompanyPackageTable(String sortField,int order, int start, int gridTableSize, String searchq);
	int getCompanyPackageTableCount(String searchq);

}
