package com.aurora.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.aurora.model.DistrictDetails;

public interface DistrictDetailsService {
	public List<DistrictDetails> getDistrictDetailsTable(String serchq);
	public int getDistrictDetailsTableCount(String serchq);
	public String saveDistrictDetails(HttpServletRequest request);
}
