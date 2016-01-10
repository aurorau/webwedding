package com.aurora.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aurora.dao.CompanyDetailsDao;
import com.aurora.service.CompanyDetailsService;

@Service("companyDetailsService")
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
	private CompanyDetailsDao companyDetailsDao = null;
	
	@Autowired
	public void setCompanyDetailsDao(CompanyDetailsDao companyDetailsDao) {
		this.companyDetailsDao = companyDetailsDao;
	}
}
