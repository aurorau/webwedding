package com.aurora.daoImpl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aurora.dao.SupplierCategoryDao;
import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.util.HibernateBase;

@Repository("supplierCategoryDao")
public class SupplierCategoryDaoImpl extends HibernateBase implements SupplierCategoryDao{

	@Transactional
	public List<SupplierCategory> getSupplierCategoryTable(String sortField,int order,int start, int length, String searchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<SupplierCategory> list = null;
		
		Criteria criteria = session.createCriteria(SupplierCategory.class,"supplierCategory")
				.setFirstResult(start)
				.setMaxResults(length);
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("scType", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("scName", searchq,MatchMode.ANYWHERE)));
		}
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	@Transactional
	public int getSupplierCategoryTableCount(String serchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(SupplierCategory.class,"supplierCategory")
				.setProjection(Projections.count("SCID"));
		
		if(!serchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("scType", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("scName", serchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
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

	public List<SupplierCategory> getAllSuppliers() {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<SupplierCategory> list = null;
		
		Criteria criteria = session.createCriteria(SupplierCategory.class,"supplierCategory");
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Transactional
	public void companyDetailsDelete(Long scid) throws Exception{

		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from SupplierCategory where SCID= :id"; 
		session.createQuery(hql).setParameter("id", scid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

}
