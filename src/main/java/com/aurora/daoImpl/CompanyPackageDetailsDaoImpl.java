package com.aurora.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.aurora.dao.CompanyPackageDetailsDao;
import com.aurora.model.CompanyDetails;
import com.aurora.model.CompanyPackageDetails;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.HibernateBase;
import com.aurora.util.PackageDetailsDTO;

@Repository("companyPackageDetailsDao")
public class CompanyPackageDetailsDaoImpl extends HibernateBase implements CompanyPackageDetailsDao {

	public CompanyPackageDetails getPackageByCPDID1(Long cpdid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		CompanyPackageDetails companyPackageDetails = null;
		
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class);
			criteria.add(Restrictions.eq("CPDID", cpdid));
	
			companyPackageDetails = (CompanyPackageDetails) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return companyPackageDetails;
	}

	public void saveCompanyPackage(CompanyPackageDetails companyPackageDetails) {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(companyPackageDetails);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<CompanyPackageDetails> getAllActivePackages() {
		List<CompanyPackageDetails> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class)
				.add(Restrictions.eq("status", "1"));
		criteria.addOrder(Order.asc("packageName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public PackageDetailsDTO getPackageByCPDID(Long cpdid) {
		PackageDetailsDTO packageDetailsDTO = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class, "companyPackageDetails")
				.createAlias("companyPackageDetails.companyDetails", "companyDetails")
				.setProjection(Projections.projectionList()
					.add(Projections.property("CPDID").as("CPDID"))
					.add(Projections.property("packageName").as("packageName"))
					.add(Projections.property("packageDescription").as("packageDescription"))
					.add(Projections.property("status").as("status"))
					.add(Projections.property("companyDetails.SCDID").as("companyId")));
			criteria.add(Restrictions.eq("CPDID", cpdid));
			criteria.addOrder(Order.asc("packageName"));
	
			packageDetailsDTO = (PackageDetailsDTO) criteria.setResultTransformer(Transformers.aliasToBean(PackageDetailsDTO.class)).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return packageDetailsDTO;
	}

	public void companyPackageDelete(Long cpdid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from CompanyPackageDetails where CPDID= :id"; 
		session.createQuery(hql).setParameter("id", cpdid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<PackageDetailsDTO> getCompanyPackageTable(String sortField,int order, int start, int gridTableSize, String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<PackageDetailsDTO> list = null;
		
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class,"companyPackageDetails")
				.createAlias("companyPackageDetails.companyDetails", "companyDetails")
				.setFirstResult(start)
				.setMaxResults(gridTableSize)
				.setProjection(Projections.projectionList()
					.add(Projections.property("CPDID").as("CPDID"))
					.add(Projections.property("packageName").as("packageName"))
					.add(Projections.property("packageDescription").as("packageDescription"))
					.add(Projections.property("status").as("status"))
					.add(Projections.property("companyDetails.SCDID").as("companyId")));
		criteria.addOrder(Order.asc("packageName"));
		criteria.add(Restrictions.eq("companyDetails.SCDID", Long.parseLong(searchq)));
		
		list = criteria.setResultTransformer(Transformers.aliasToBean(PackageDetailsDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getCompanyPackageTableCount(String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class,"companyPackageDetails")
				.createAlias("companyPackageDetails.companyDetails", "companyDetails")
				.setProjection(Projections.count("CPDID"));
		criteria.add(Restrictions.eq("companyDetails.SCDID", Long.parseLong(searchq)));
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

	public List<CompanyPackageDetails> getAllActivePackagesByCompanyId(Long companyId) {
		List<CompanyPackageDetails> list = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(CompanyPackageDetails.class,"companyPackageDetails")
				.createAlias("companyPackageDetails.companyDetails", "companyDetails")
				.add(Restrictions.eq("companyDetails.SCDID", companyId))
				.add(Restrictions.eq("status", "1"));
		criteria.addOrder(Order.asc("packageName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
