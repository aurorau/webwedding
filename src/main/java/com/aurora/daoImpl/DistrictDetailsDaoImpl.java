package com.aurora.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aurora.dao.DistrictDetailsDao;
import com.aurora.model.DistrictDetails;
import com.aurora.util.HibernateBase;

@Repository("districtDetailsDao")
public class DistrictDetailsDaoImpl extends HibernateBase implements DistrictDetailsDao {

	public List<DistrictDetails> getDistrictDetailsTable(String serchq) throws Exception {

		return null;
	}

	public int getDistrictDetailsTableCount(String serchq) throws Exception {
		return 0;
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
