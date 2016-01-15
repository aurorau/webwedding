package com.aurora.dao;

import java.util.List;

import com.aurora.model.DistrictDetails;

public interface DistrictDetailsDao {
	public List<DistrictDetails> getDistrictDetailsTable(String sortField, int order, int start, int length,String searchq)throws Exception;
	public int getDistrictDetailsTableCount(String serchq)throws Exception;
	public void saveDistrictDetails(DistrictDetails districtDetails)throws Exception;
	public DistrictDetails getDistrictDetailsByDDID(Long ddid) throws Exception;
	public List<DistrictDetails> getAllDistricts();
}
