package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.aurora.model.DistrictDetails;

public interface DistrictDetailsService {
	public List<DistrictDetails> getDistrictDetailsTable(String sortField,int order,int start, int length, String searchq);
	public int getDistrictDetailsTableCount(String serchq);
	public String saveDistrictDetails(HttpServletRequest request);
	public DistrictDetails getDistrictDetailsByDDID(HttpServletRequest request);
	public List<DistrictDetails> getAllDistricts();
	public String districtDetailsDelete(HttpServletRequest request);
}
