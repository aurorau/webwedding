package com.aurora.daoImpl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.util.HibernateBase;

@Repository("supplierCategoryDao")
public class SupplierCategoryDaoImpl extends HibernateBase implements SupplierCategoryDao{

	@Transactional
	public List<SupplierCategory> getSupplierCategoryTable(String serchq) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public int getSupplierCategoryTableCount(String serchq) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public void saveSupplierCategory(SupplierCategory supplierCategory) throws Exception {
		Session session = getSession();
		
		session.getTransaction().begin();
		session.saveOrUpdate(supplierCategory);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public SupplierCategory getSupplierCategoryBySCID(Long scid) throws Exception {
		SupplierCategory supplierCategory = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(SupplierCategory.class, "supplierCategory");
			criteria.add(Restrictions.eq("SCID", scid));
	
			supplierCategory = (SupplierCategory) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return supplierCategory;
	}

}
