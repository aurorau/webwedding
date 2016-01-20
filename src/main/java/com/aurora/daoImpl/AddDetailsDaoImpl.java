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
import com.aurora.dao.AddDetailsDao;
import com.aurora.model.AddDetails;
import com.aurora.util.HibernateBase;

@Repository("addDetailsDao")
public class AddDetailsDaoImpl extends HibernateBase implements AddDetailsDao {

	@Transactional
	public AddDetails getAddDetailsByAID1(Long aid)throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		AddDetails addDetails = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class);
			criteria.add(Restrictions.eq("AID", aid));
			addDetails = (AddDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return addDetails;
	}
	
	@Transactional
	public void saveAddDetails(AddDetails addDetails) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(addDetails);
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public void addDetailsDelete(Long aid) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from AddDetails where AID= :id"; 
		session.createQuery(hql).setParameter("id", aid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public List<AddDetails> getAddDetailTable(String sortField, int order, int start, int gridTableSize,String searchq) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		List<AddDetails> list = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class)
				.setFirstResult(start)
				.setMaxResults(gridTableSize);
		criteria.addOrder(Order.asc("addSupplierName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("addSupplierName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addSupplierEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addLink", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addSupplierTp", searchq, MatchMode.ANYWHERE)));
		}
		
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Transactional
	public int getAddDetailTableCount(String searchq) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(AddDetails.class)
				.setProjection(Projections.count("AID"));
		
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("addSupplierName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addSupplierEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addLink", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("addSupplierTp", searchq, MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	@Transactional
	public List<AddDetails> getAllAdds() throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		List<AddDetails> list = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class);
		criteria.addOrder(Order.asc("addSupplierName"));
		
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
