package com.aurora.dao;

import java.util.List;

import com.aurora.model.AddDetails;

public interface AddDetailsDao {

	AddDetails getAddDetailsByAID1(Long aid)throws Exception;
	void saveAddDetails(AddDetails addDetails)throws Exception;
	void addDetailsDelete(Long aid) throws Exception;
	List<AddDetails> getAddDetailTable(String sortField, int order, int start, int gridTableSize, String searchq)throws Exception;
	int getAddDetailTableCount(String searchq)throws Exception;
	List<AddDetails> getAllAdds() throws Exception;

}
