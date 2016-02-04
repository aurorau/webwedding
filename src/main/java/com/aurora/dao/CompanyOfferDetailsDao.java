package com.aurora.dao;

import java.util.List;

import com.aurora.model.CompanyOffers;
import com.aurora.util.OfferDetailsDTO;

public interface CompanyOfferDetailsDao {

	CompanyOffers getOfferByCODID1(Long codid);
	void saveCompanyOffer(CompanyOffers companyOffers);
	List<CompanyOffers> getAllActiveOffers();
	OfferDetailsDTO getOfferByCODID(Long codid);
	List<CompanyOffers> getActiveOfferByCompanyId(Long companyId);
	void companyOfferDelete(Long codid);
	List<OfferDetailsDTO> getCompanyOfferTable(String sortField, int order,int start, int gridTableSize, String searchq);
	int getCompanyOfferTableCount(String searchq);

}
