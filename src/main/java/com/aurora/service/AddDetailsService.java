package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aurora.model.AddDetails;
import com.aurora.util.AddDetailsDTO;

public interface AddDetailsService {

	String saveAddDetails(HttpServletRequest request);
	List<AddDetails> getAllAdds();
	AddDetails getAddDetailsByAID(HttpServletRequest request);
	String addDetailsDelete(HttpServletRequest request);
	List<AddDetails> getAddDetailTable(String sortField, int order, int start, int gridTableSize, String searchq);
	int getAddDetailTableCount(String searchq);

}
