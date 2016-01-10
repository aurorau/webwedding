package com.aurora.daoImpl;

import org.springframework.stereotype.Repository;

import com.aurora.dao.CompanyDetailsDao;
import com.aurora.util.HibernateBase;

@Repository("companyDetailsDao")
public class CompanyDetailsDaoImpl extends HibernateBase implements CompanyDetailsDao {

}
