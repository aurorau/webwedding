package com.aurora.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.aurora.dao.AddDetailsDao;
import com.aurora.model.AddDetails;
import com.aurora.util.AddDetailsDTO;
import com.aurora.util.HibernateBase;
import com.aurora.util.ImageCategoryDTO;

@Repository("addDetailsDao")
public class AddDetailsDaoImpl extends HibernateBase implements AddDetailsDao {


	public AddDetails getAddDetailsByAID1(Long aid)throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		AddDetails addDetails = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class, "addDetails");
				//.createAlias("addDetails.imageTable", "imageTable", JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("AID", aid));
			addDetails = (AddDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return addDetails;
	}
	
	public void saveAddDetails(AddDetails addDetails) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(addDetails);
		session.getTransaction().commit();
		session.close();
		
	}

	public void addDetailsDelete(Long aid) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from AddDetails where AID= :id"; 
		session.createQuery(hql).setParameter("id", aid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<AddDetailsDTO> getAddDetailTable(String sortField, int order, int start, int gridTableSize,String searchq) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		List<AddDetailsDTO> list = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class, "addDetails")
				.createAlias("addDetails.imageTable", "imageTable", JoinType.LEFT_OUTER_JOIN)
				//.createAlias("addDetails.imageTable", "imageTable", JoinType.LEFT_OUTER_JOIN)
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
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("AID").as("AID"))
				.add(Projections.property("addSupplierName").as("addSupplierName"))
				.add(Projections.property("addSupplierTp").as("addSupplierTp"))
				.add(Projections.property("addSupplierAddress").as("addSupplierAddress"))
				.add(Projections.property("addSupplierEmail").as("addSupplierEmail"))
				.add(Projections.property("addDescription").as("addDescription"))
				.add(Projections.property("addStatus").as("addStatus"))
				.add(Projections.property("addRegisteredDate").as("addRegisteredDate"))
				.add(Projections.property("addActiveDate").as("addActiveDate"))
				.add(Projections.property("addActivePeriod").as("addActivePeriod"))
				.add(Projections.property("addUrl").as("addUrl"))
				.add(Projections.property("addLink").as("addLink"))
				.add(Projections.property("imageTable.ITID").as("ITID")));
		list = (List<AddDetailsDTO>) criteria.setResultTransformer(Transformers.aliasToBean(AddDetailsDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

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

	public List<AddDetailsDTO> getAllAdds() throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		List<AddDetailsDTO> list = null;
		
		Criteria criteria = session.createCriteria(AddDetails.class,"addDetails")
				.createAlias("addDetails.imageTable", "imageTable");
		criteria.addOrder(Order.asc("addSupplierName"));
		criteria.add(Restrictions.ne("addStatus", "2"));
		
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("AID").as("AID"))
				.add(Projections.property("addSupplierName").as("addSupplierName"))
				.add(Projections.property("addSupplierTp").as("addSupplierTp"))
				.add(Projections.property("addSupplierAddress").as("addSupplierAddress"))
				.add(Projections.property("addSupplierEmail").as("addSupplierEmail"))
				.add(Projections.property("addDescription").as("addDescription"))
				.add(Projections.property("addStatus").as("addStatus"))
				.add(Projections.property("addRegisteredDate").as("addRegisteredDate"))
				.add(Projections.property("addActiveDate").as("addActiveDate"))
				.add(Projections.property("addActivePeriod").as("addActivePeriod"))
				.add(Projections.property("addUrl").as("addUrl"))
				.add(Projections.property("addLink").as("addLink"))
				.add(Projections.property("imageTable.ITID").as("ITID")));
		list = (List<AddDetailsDTO>) criteria.setResultTransformer(Transformers.aliasToBean(AddDetailsDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
