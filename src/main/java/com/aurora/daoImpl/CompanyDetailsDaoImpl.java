package com.aurora.daoImpl;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.aurora.dao.CompanyDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.HibernateBase;

@Repository("companyDetailsDao")
public class CompanyDetailsDaoImpl extends HibernateBase implements CompanyDetailsDao {
	
	@Transactional
	public List<CompanyDetails> getCompanyDetailsTable(String sortField, int order, int start, int length,String searchq) throws Exception {
		List<CompanyDetails> list = null;
		
		Criteria criteria = getSession().createCriteria(CompanyDetails.class,"companyDetails")
				.setFirstResult(start)
				.setMaxResults(length);
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("companyName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyAddress", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp1", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp2", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyRegistrationNumber", searchq,MatchMode.ANYWHERE)));
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

	@Transactional
	public int getCompanyDetailsTableCount(String searchq) throws Exception {
		int totalRowCount =0;
		Criteria criteria = getSession().createCriteria(CompanyDetails.class,"companyDetails")
				.setProjection(Projections.count("SCDID"));
		
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("companyName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyAddress", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp1", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp2", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyRegistrationNumber", searchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		return totalRowCount;
	}

	@Transactional
	public void saveCompanyDetails(CompanyDetails companyDetails) throws Exception {
		Session session = getSession();
		
		session.getTransaction().begin();
		session.saveOrUpdate(companyDetails);
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public CompanyDetailsDTO getCompanyDetailsBySCDID(Long scdid) throws Exception {
		CompanyDetailsDTO companyDetails = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class, "companyDetails")
				.createAlias("companyDetails.supplierPersonalDetails", "supplierPersonalDetails")
				.createAlias("companyDetails.supplierCategory", "supplierCategory")
				.createAlias("companyDetails.districtDetails", "districtDetails")
				.setProjection(Projections.projectionList()
					.add(Projections.property("SCDID").as("SCDID"))
					.add(Projections.property("companyName").as("companyName"))
					.add(Projections.property("companyAddress").as("companyAddress"))
					.add(Projections.property("companyTp1").as("companyTp1"))
					.add(Projections.property("companyTp2").as("companyTp2"))
					.add(Projections.property("companyEmail").as("companyEmail"))
					.add(Projections.property("companyFaxNo").as("companyFaxNo"))
					.add(Projections.property("companyWebURl").as("companyWebURl"))
					.add(Projections.property("companyFbPage").as("companyFbPage"))
					.add(Projections.property("budget").as("budget"))
					.add(Projections.property("status").as("status"))
					.add(Projections.property("companyRegisteredDate").as("companyRegisteredDate"))
					.add(Projections.property("companyRegistrationNumber").as("companyRegistrationNumber"))
					.add(Projections.property("activeDate").as("activeDate"))
					.add(Projections.property("activePeriod").as("activePeriod"))
					.add(Projections.property("supplierPersonalDetails.SPDID").as("supplierPersonalDetails"))
					.add(Projections.property("supplierCategory.SCID").as("supplierCategory"))
					.add(Projections.property("districtDetails.DDID").as("districtDetails")));
			criteria.add(Restrictions.eq("SCDID", scdid));
	
			companyDetails = (CompanyDetailsDTO) criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsDTO.class)).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyDetails;
	}
	@Transactional
	public CompanyDetails getCompanyDetailsBySCDID1(Long scid) throws Exception {
		CompanyDetails companyDetails = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class, "companyDetails");
			criteria.add(Restrictions.eq("SCDID", scid));
	
			companyDetails = (CompanyDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyDetails;
	}
	@Transactional
	public void companyDetailsDelete(Long scdid){
		try {
			Session session = getSession();
			session.getTransaction().begin();
			
			String hql = "delete from CompanyDetails where SCDID= :id"; 
			session.createQuery(hql).setParameter("id", scdid).executeUpdate();
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Delete Error:"+e);
		}
	}

	@Transactional
	public List<CompanyDetails> getAllCompaniesByCategory(Long categoryId) {
		List<CompanyDetails> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
				.add(Restrictions.eq("companyDetails.supplierCategory.SCID", categoryId));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
