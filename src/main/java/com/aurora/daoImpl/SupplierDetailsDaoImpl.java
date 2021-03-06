package com.aurora.daoImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aurora.dao.SupplierDetailsDao;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.util.HibernateBase;

@Repository("SupplierDetailsDao")
public class SupplierDetailsDaoImpl extends HibernateBase implements SupplierDetailsDao {

	public List<SupplierPersonalDetails> getSupplierPersonalDetailsable(String sortField, int order, int start,int length, String searchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<SupplierPersonalDetails> list = null;
		
		Criteria criteria = session.createCriteria(SupplierPersonalDetails.class,"supplierPersonalDetails")
				.setFirstResult(start)
				.setMaxResults(length);
		criteria.addOrder(Order.asc("supplierFirstName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("supplierFirstName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierLastName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierTp1", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierTp2", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierSkypeAddress", searchq,MatchMode.ANYWHERE)));
		}
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getSupplierPersonalDetailsCount(String serchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(SupplierPersonalDetails.class,"supplierPersonalDetails")
				.setProjection(Projections.count("SPDID"));
		
		if(!serchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("supplierFirstName", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierLastName", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierEmail", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierTp1", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierTp2", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("supplierSkypeAddress", serchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public void saveSupplierPersonalDetails(SupplierPersonalDetails supplierPersonalDetails) throws Exception {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(supplierPersonalDetails);
		session.getTransaction().commit();
		session.close();
	}

	public SupplierPersonalDetails getSupplierPersonalDetailsBySPDID(Long spdid) throws Exception {
		SupplierPersonalDetails supplierPersonalDetails = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(SupplierPersonalDetails.class, "supplierPersonalDetails");
			criteria.add(Restrictions.eq("SPDID", spdid));
	
			supplierPersonalDetails = (SupplierPersonalDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return supplierPersonalDetails;
	}

	public List<SupplierPersonalDetails> getAllSuppliers() {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<SupplierPersonalDetails> list = null;
		
		Criteria criteria = session.createCriteria(SupplierPersonalDetails.class,"supplierPersonalDetails");
		         criteria.addOrder(Order.asc("supplierFirstName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public void supplierDetailsDelete(Long spdid)throws Exception {

		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from SupplierPersonalDetails where SPDID= :id"; 
		session.createQuery(hql).setParameter("id", spdid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

}
