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
import com.aurora.dao.DistrictDetailsDao;
import com.aurora.model.DistrictDetails;
import com.aurora.util.HibernateBase;

@Repository("districtDetailsDao")
public class DistrictDetailsDaoImpl extends HibernateBase implements DistrictDetailsDao {

	public List<DistrictDetails> getDistrictDetailsTable(String sortField, int order, int start, int length,String searchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<DistrictDetails> list = null;
		
		Criteria criteria = session.createCriteria(DistrictDetails.class,"districtDetails")
				.setFirstResult(start)
				.setMaxResults(length);
		criteria.addOrder(Order.asc("districtName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("districtCode", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("districtName", searchq,MatchMode.ANYWHERE)));
		}
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getDistrictDetailsTableCount(String serchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria =session.createCriteria(DistrictDetails.class,"districtDetails")
				.setProjection(Projections.count("DDID"));
		
		if(!serchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("districtCode", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("districtName", serchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public void saveDistrictDetails(DistrictDetails districtDetails) throws Exception {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(districtDetails);
		session.getTransaction().commit();
		session.close();
	}

	public DistrictDetails getDistrictDetailsByDDID(Long ddid) throws Exception {
		DistrictDetails districtDetails = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(DistrictDetails.class, "districtDetails");
			criteria.add(Restrictions.eq("DDID", ddid));
	
		districtDetails = (DistrictDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return districtDetails;
	}

	public List<DistrictDetails> getAllDistricts() {
		Session session = getSession();
		session.getTransaction().begin();
		List<DistrictDetails> list = null;
		
		Criteria criteria = session.createCriteria(DistrictDetails.class,"districtDetails");
				 criteria.addOrder(Order.asc("districtName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public void districtDetailsDelete(Long ddid) throws Exception{

		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from DistrictDetails where DDID= :id"; 
		session.createQuery(hql).setParameter("id", ddid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

}
