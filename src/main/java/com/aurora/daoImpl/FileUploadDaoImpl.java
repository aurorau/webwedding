package com.aurora.daoImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aurora.dao.FileUploadDao;
import com.aurora.model.UploadFiles;
import com.aurora.util.HibernateBase;

@Repository("fileUploadDao")
public class FileUploadDaoImpl extends HibernateBase implements FileUploadDao {

	@Transactional
	public UploadFiles getFileDetailsByFUID(Long fuid) {
		UploadFiles uploadFiles = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(UploadFiles.class, "uploadFiles");
			criteria.add(Restrictions.eq("UFID", fuid));
	
			uploadFiles = (UploadFiles) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return uploadFiles;
	}

	@Transactional
	public void saveFile(UploadFiles uploadFiles) {
		
		Session session = getSession();
		
		session.getTransaction().begin();
		session.saveOrUpdate(uploadFiles);
		session.getTransaction().commit();
		session.close();
	}
	@Transactional
	public List<UploadFiles> getFileDetailsTable(String sortField, int order, int start, int gridTableSize,Long caterogyId, Long companyId, String searchq) {
		List<UploadFiles> list = null;
		
		Criteria criteria = getSession().createCriteria(UploadFiles.class,"uploadFiles")
				.createAlias("uploadFiles.supplierCategory", "supplierCategory")
				.add(Restrictions.eq("supplierCategory.SCID", caterogyId));
		
		if(companyId != 0){
			criteria.createAlias("uploadFiles.supplierCompanyDetails", "supplierCompanyDetails")
					.add(Restrictions.eq("supplierCompanyDetails.SCDID", companyId));
		}
		
		criteria.setFirstResult(start)
				.setMaxResults(gridTableSize);
		
		list = criteria.list();
		return list;
	}
	@Transactional
	public int getFileDetailsTableCount(Long caterogyId, Long companyId, String searchq) {
		int totalRowCount =0;
		
		Criteria criteria = getSession().createCriteria(UploadFiles.class,"uploadFiles")
				.createAlias("uploadFiles.supplierCategory", "supplierCategory")
				.add(Restrictions.eq("supplierCategory.SCID", caterogyId))
				.setProjection(Projections.count("UFID"));
		
		if(companyId != 0){
			criteria.createAlias("uploadFiles.supplierCompanyDetails", "supplierCompanyDetails")
					.add(Restrictions.eq("supplierCompanyDetails.SCDID", companyId));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
	
		return totalRowCount;
	}
	
	@Transactional
	public void deleteImage(long parseLong) {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from UploadFiles where UFID= :id"; 
		session.createQuery(hql).setParameter("id", parseLong).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

}
