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
		List<DistrictDetails> list = null;
		
		Criteria criteria = getSession().createCriteria(DistrictDetails.class,"districtDetails")
				.setFirstResult(start)
				.setMaxResults(length);
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("districtCode", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("districtName", searchq,MatchMode.ANYWHERE)));
		}
/*		if(!sortField.isEmpty()) {
			if(order == 0) {
				criteria.addOrder(Order.asc(sortField));
			} else if(order == 1) {
				criteria.addOrder(Order.desc(sortField));
			}
		}*/
		list = criteria.list();
		return list;
	}

	public int getDistrictDetailsTableCount(String serchq) throws Exception {
		int totalRowCount =0;
		Criteria criteria = getSession().createCriteria(DistrictDetails.class,"districtDetails")
				.setProjection(Projections.count("DDID"));
		
		if(!serchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("districtCode", serchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("districtName", serchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		return totalRowCount;
	}

	@Transactional
	public void saveDistrictDetails(DistrictDetails districtDetails) throws Exception {
		Session session = getSession();
		
		session.getTransaction().begin();
		session.saveOrUpdate(districtDetails);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
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

}
