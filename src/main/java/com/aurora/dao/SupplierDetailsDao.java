package com.aurora.dao;

import java.util.List;
import com.aurora.model.SupplierPersonalDetails;

public interface SupplierDetailsDao {
	public List<SupplierPersonalDetails> getSupplierPersonalDetailsable(String sortField,int order,int start, int length, String searchq)throws Exception;
	public int getSupplierPersonalDetailsCount(String serchq) throws Exception;
	public void saveSupplierPersonalDetails(SupplierPersonalDetails supplierPersonalDetails)throws Exception;
	public SupplierPersonalDetails getSupplierPersonalDetailsBySPDID(Long spdid)throws Exception;
	public List<SupplierPersonalDetails> getAllSuppliers();
	public void supplierDetailsDelete(Long spdid) throws Exception;
}
