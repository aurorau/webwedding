package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.CompanyOffers;
import com.aurora.model.CompanyPackageDetails;
import com.aurora.util.OfferDetailsDTO;

public interface CompanyOfferDetailsService {

	String saveCompanyOffer(HttpServletRequest request);
	List<CompanyOffers> getAllActiveOffers();
	OfferDetailsDTO getOfferByCODID(HttpServletRequest request);
	String companyOfferDelete(HttpServletRequest request);
	List<OfferDetailsDTO> getCompanyOfferTable(String sortField, int order,int start, int gridTableSize, String searchq);
	int getCompanyOfferTableCount(String searchq);

}
