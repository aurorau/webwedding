package com.aurora.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aurora.model.AddDetails;
import com.aurora.util.AddDetailsDTO;

public interface AddDetailsService {

	String saveAddDetails(MultipartHttpServletRequest request);
	List<AddDetailsDTO> getAllAdds();
	AddDetails getAddDetailsByAID(HttpServletRequest request);
	String addDetailsDelete(HttpServletRequest request);
	List<AddDetailsDTO> getAddDetailTable(String sortField, int order, int start, int gridTableSize, String searchq);
	int getAddDetailTableCount(String searchq);

}
