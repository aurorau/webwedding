package com.aurora.dao;

import java.util.List;

import com.aurora.model.CompanyPackageDetails;
import com.aurora.util.PackageDetailsDTO;

public interface CompanyPackageDetailsDao {

	CompanyPackageDetails getPackageByCPDID1(Long cpdid);
	void saveCompanyPackage(CompanyPackageDetails companyPackageDetails);
	List<CompanyPackageDetails> getAllActivePackages();
	List<CompanyPackageDetails> getAllActivePackagesByCompanyId(Long companyId);
	PackageDetailsDTO getPackageByCPDID(Long cpdid);
	void companyPackageDelete(Long cpdid);
	List<PackageDetailsDTO> getCompanyPackageTable(String sortField,int order, int start, int gridTableSize, String searchq);
	int getCompanyPackageTableCount(String searchq);

}
