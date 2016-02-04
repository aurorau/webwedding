package com.aurora.daoImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.aurora.dao.CompanyDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.CompanyDetailsW2DTO;
import com.aurora.util.HibernateBase;

@Repository("companyDetailsDao")
public class CompanyDetailsDaoImpl extends HibernateBase implements CompanyDetailsDao {
	
	public List<CompanyDetailsDTO> getCompanyDetailsTable(String sortField, int order, int start, int length,String searchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<CompanyDetailsDTO> list = null;
		
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
				.createAlias("companyDetails.supplierPersonalDetails", "supplierPersonalDetails")
				.createAlias("companyDetails.supplierCategory", "supplierCategory")
				.createAlias("companyDetails.districtDetails", "districtDetails")
				.createAlias("companyDetails.imageTable", "imageTable")
				.setFirstResult(start)
				.setMaxResults(length);
		criteria.addOrder(Order.asc("companyName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("companyName", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyAddress", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyEmail", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp1", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyTp2", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("companyRegistrationNumber", searchq,MatchMode.ANYWHERE)));
		}
		
		criteria.setProjection(Projections.projectionList()
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
				.add(Projections.property("supplierPersonalDetails.supplierFirstName").as("supplierPersonalDetailsFName"))
				.add(Projections.property("supplierCategory.SCID").as("supplierCategory"))
				.add(Projections.property("imageTable.ITID").as("ITID"))
				.add(Projections.property("companyDescription").as("companyDescription"))
				.add(Projections.property("districtDetails.DDID").as("districtDetails")));
		
		list = (List<CompanyDetailsDTO>) criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getCompanyDetailsTableCount(String searchq) throws Exception {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
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
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public void saveCompanyDetails(CompanyDetails companyDetails) throws Exception {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(companyDetails);
		session.getTransaction().commit();
		session.close();
		
	}

	public CompanyDetailsDTO getCompanyDetailsBySCDID(Long scdid) throws Exception {
		CompanyDetailsDTO companyDetails = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class, "companyDetails")
				.createAlias("companyDetails.supplierPersonalDetails", "supplierPersonalDetails")
				.createAlias("companyDetails.supplierCategory", "supplierCategory")
				.createAlias("companyDetails.districtDetails", "districtDetails")
				.createAlias("companyDetails.imageTable", "imageTable")
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
					.add(Projections.property("supplierPersonalDetails.supplierFirstName").as("supplierPersonalDetailsFName"))
					.add(Projections.property("supplierCategory.SCID").as("supplierCategory"))
					.add(Projections.property("imageTable.ITID").as("ITID"))
					.add(Projections.property("companyDescription").as("companyDescription"))
					.add(Projections.property("districtDetails.DDID").as("districtDetails")));
			criteria.add(Restrictions.eq("SCDID", scdid));
			criteria.addOrder(Order.asc("companyName"));
	
			companyDetails = (CompanyDetailsDTO) criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsDTO.class)).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyDetails;
	}

	public CompanyDetails getCompanyDetailsBySCDID1(Long scid) throws Exception {
		Session session = getSession();
		session.getTransaction().begin();
		
		CompanyDetails companyDetails = null;
		
		Criteria criteria = session.createCriteria(CompanyDetails.class, "companyDetails");
			criteria.add(Restrictions.eq("SCDID", scid));
	
			companyDetails = (CompanyDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyDetails;
	}

	public void companyDetailsDelete(Long scdid) throws Exception{

		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from CompanyDetails where SCDID= :id"; 
		session.createQuery(hql).setParameter("id", scdid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();

	}

	public List<CompanyDetails> getAllCompaniesByCategory(Long categoryId) {
		List<CompanyDetails> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
				.add(Restrictions.eq("companyDetails.supplierCategory.SCID", categoryId));
		criteria.addOrder(Order.asc("companyName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public List<CompanyDetailsW2DTO> getCompanyDetailsTableW2(String sortField, int order, int start, int gridTableSize,Long serviceCategoryDD, Long districtDD, Long budget) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<CompanyDetailsW2DTO> list = null;
		
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
				.createAlias("companyDetails.supplierPersonalDetails", "supplierPersonalDetails")
				.createAlias("companyDetails.supplierCategory", "supplierCategory")
				.createAlias("companyDetails.districtDetails", "districtDetails")
				.createAlias("companyDetails.imageTable", "imageTable")
				.setFirstResult(start)
				.setMaxResults(gridTableSize);
		//criteria.add(Restrictions.neOrIsNotNull("logoUrl",""));
		criteria.addOrder(Order.asc("companyName"));
		
		if(serviceCategoryDD != 0) {
			criteria.add(Restrictions.eq("supplierCategory.SCID",serviceCategoryDD));
		}
		if(districtDD != 0) {
			criteria.add(Restrictions.eq("districtDetails.DDID",districtDD));
		}
		if(budget != 0) {
			criteria.add(Restrictions.ge("budget",budget));
		}	
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("SCDID").as("SCDID"))
				.add(Projections.property("companyName").as("companyName"))
				.add(Projections.property("companyAddress").as("companyAddress"))
				.add(Projections.property("companyTp1").as("companyTp1"))
				.add(Projections.property("companyTp2").as("companyTp2"))
				.add(Projections.property("companyEmail").as("companyEmail"))
				.add(Projections.property("companyFaxNo").as("companyFaxNo"))
				.add(Projections.property("companyWebURl").as("companyWebURl"))
				.add(Projections.property("companyFbPage").as("companyFbPage"))
				.add(Projections.property("imageTable.ITID").as("ITID"))
				.add(Projections.property("supplierPersonalDetails.supplierFirstName").as("supplierPersonalDetailsFName"))
				.add(Projections.property("supplierPersonalDetails.supplierLastName").as("supplierPersonalDetailsFLName"))
				.add(Projections.property("supplierPersonalDetails.supplierSkypeAddress").as("supplierPersonalDetailsSkype"))
				.add(Projections.property("budget").as("budget")));
		
		list = (List<CompanyDetailsW2DTO>) criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsW2DTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getCompanyDetailsTableCountW2(Long serviceCategoryDD, Long districtDD, Long budget) {
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(CompanyDetails.class,"companyDetails")
				.setProjection(Projections.count("SCDID"));
		//criteria.add(Restrictions.neOrIsNotNull("logoUrl",""));
		
		if(serviceCategoryDD != 0) {
			criteria.createAlias("companyDetails.supplierCategory", "supplierCategory");
			criteria.add(Restrictions.eq("supplierCategory.SCID",serviceCategoryDD));
		}
		if(districtDD != 0) {
			criteria.createAlias("companyDetails.districtDetails", "districtDetails");
			criteria.add(Restrictions.eq("districtDetails.DDID",districtDD));
		}
		if(budget != 0) {
			criteria.add(Restrictions.ge("budget",budget));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public List<CompanyDetails> getAllCompanies() {
		List<CompanyDetails> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyDetails.class)
				.add(Restrictions.eq("status", "1"));
		criteria.addOrder(Order.asc("companyName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
