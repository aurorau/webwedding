package com.aurora.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.aurora.dao.CompanyOfferDetailsDao;
import com.aurora.model.CompanyOffers;
import com.aurora.util.HibernateBase;
import com.aurora.util.OfferDetailsDTO;

@Repository("companyOfferDetailsDao")
public class CompanyOfferDetailsDaoImpl extends HibernateBase implements CompanyOfferDetailsDao {

	public CompanyOffers getOfferByCODID1(Long codid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		CompanyOffers companyOffers = null;
		
		Criteria criteria = session.createCriteria(CompanyOffers.class);
			criteria.add(Restrictions.eq("CODID", codid));
	
			companyOffers = (CompanyOffers) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyOffers;
	}

	public void saveCompanyOffer(CompanyOffers companyOffers) {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(companyOffers);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<CompanyOffers> getAllActiveOffers() {
		List<CompanyOffers> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyOffers.class)
				.add(Restrictions.eq("status", "1"));
		criteria.addOrder(Order.asc("offerName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public OfferDetailsDTO getOfferByCODID(Long codid) {
		OfferDetailsDTO offerDetailsDTO = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyOffers.class, "companyOffers")
				.createAlias("companyOffers.companyDetails", "companyDetails")
				.setProjection(Projections.projectionList()
					.add(Projections.property("CODID").as("CODID"))
					.add(Projections.property("offerName").as("offerName"))
					.add(Projections.property("offerDescription").as("offerDescription"))
					.add(Projections.property("offerStartDate").as("offerStartDate"))
					.add(Projections.property("offerEndDate").as("offerEndDate"))
					.add(Projections.property("status").as("status"))
					.add(Projections.property("companyDetails.SCDID").as("companyId")));
			criteria.add(Restrictions.eq("CODID", codid));
			criteria.addOrder(Order.asc("offerName"));
	
			offerDetailsDTO = (OfferDetailsDTO) criteria.setResultTransformer(Transformers.aliasToBean(OfferDetailsDTO.class)).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return offerDetailsDTO;
	}

	public void companyOfferDelete(Long codid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from CompanyOffers where CODID= :id"; 
		session.createQuery(hql).setParameter("id", codid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<OfferDetailsDTO> getCompanyOfferTable(String sortField,int order, int start, int gridTableSize, String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<OfferDetailsDTO> list = null;
		
		Criteria criteria = session.createCriteria(CompanyOffers.class,"companyOffers")
				.createAlias("companyOffers.companyDetails", "companyDetails")
				.setFirstResult(start)
				.setMaxResults(gridTableSize)
				.setProjection(Projections.projectionList()
					.add(Projections.property("CODID").as("CODID"))
					.add(Projections.property("offerName").as("offerName"))
					.add(Projections.property("offerDescription").as("offerDescription"))
					.add(Projections.property("offerStartDate").as("offerStartDate"))
					.add(Projections.property("offerEndDate").as("offerEndDate"))
					.add(Projections.property("status").as("status"))
					.add(Projections.property("companyDetails.SCDID").as("companyId")));
		criteria.addOrder(Order.asc("offerName"));
		criteria.add(Restrictions.eq("companyDetails.SCDID", Long.parseLong(searchq)));
		
		list = criteria.setResultTransformer(Transformers.aliasToBean(OfferDetailsDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getCompanyOfferTableCount(String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(CompanyOffers.class,"companyOffers")
				.createAlias("companyOffers.companyDetails", "companyDetails")
				.setProjection(Projections.count("CODID"));
		criteria.add(Restrictions.eq("companyDetails.SCDID", Long.parseLong(searchq)));
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public List<CompanyOffers> getActiveOfferByCompanyId(Long companyId) {
		
		List<CompanyOffers> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		CompanyOffers companyOffers = null;
		
		Criteria criteria = session.createCriteria(CompanyOffers.class,"companyOffers")
				.createAlias("companyOffers.companyDetails", "companyDetails");
			criteria.add(Restrictions.eq("companyDetails.SCDID", companyId))
					.add(Restrictions.eq("status", "1"));
	
			list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
