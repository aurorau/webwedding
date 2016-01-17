package com.aurora.daoImpl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.commons.fileupload.FileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.aurora.dao.FileUploadDao;
import com.aurora.model.UploadFiles;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.FileUploadDTO;
import com.aurora.util.HibernateBase;

@Repository("fileUploadDao")
public class FileUploadDaoImpl extends HibernateBase implements FileUploadDao {

	@Transactional
	public UploadFiles getFileDetailsByFUID(Long fuid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		UploadFiles uploadFiles = null;
		
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
	public List<FileUploadDTO> getFileDetailsTable(String sortField, int order, int start, int gridTableSize,Long caterogyId, Long companyId, String searchq) {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		List<FileUploadDTO> list = null;
		
		Criteria criteria = session.createCriteria(UploadFiles.class,"uploadFiles")
				.createAlias("uploadFiles.supplierCategory", "supplierCategory")
				//.createAlias("uploadFiles.supplierCompanyDetails", "supplierCompanyDetails")
				.add(Restrictions.eq("supplierCategory.SCID", caterogyId));

		
		if(companyId != 0){
			criteria.createAlias("supplierCompanyDetails", "supplierCompanyDetails");
			criteria.add(Restrictions.eq("supplierCompanyDetails.SCDID", companyId));
			

		}
		
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("UFID").as("UFID"))
				.add(Projections.property("fileUrl").as("fileUrl"))
				.add(Projections.property("fileUploadDate").as("fileUploadDate")));
		
		
		criteria.setFirstResult(start)
				.setMaxResults(gridTableSize);
		
		list = (List<FileUploadDTO>) criteria.setResultTransformer(Transformers.aliasToBean(FileUploadDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Transactional
	public int getFileDetailsTableCount(Long caterogyId, Long companyId, String searchq) {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		
		Criteria criteria = session.createCriteria(UploadFiles.class,"uploadFiles")
				.createAlias("uploadFiles.supplierCategory", "supplierCategory")
				.add(Restrictions.eq("supplierCategory.SCID", caterogyId))
				.setProjection(Projections.count("UFID"));
		
		if(companyId != 0){
			criteria.createAlias("uploadFiles.supplierCompanyDetails", "supplierCompanyDetails")
					.add(Restrictions.eq("supplierCompanyDetails.SCDID", companyId));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
	
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}
	
	@Transactional
	public void deleteImage(long parseLong) throws Exception {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from UploadFiles where UFID= :id"; 
		session.createQuery(hql).setParameter("id", parseLong).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public List<FileUploadDTO> getFileDetailsByCompanyId(Long scdid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<FileUploadDTO> list = null;
		
		Criteria criteria = session.createCriteria(UploadFiles.class,"uploadFiles")
				.createAlias("uploadFiles.supplierCompanyDetails", "supplierCompanyDetails")
				.add(Restrictions.eq("supplierCompanyDetails.SCDID", scdid));

		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("UFID").as("UFID"))
				.add(Projections.property("fileUrl").as("fileUrl"))
				.add(Projections.property("fileUploadDate").as("fileUploadDate")));
		
		list = (List<FileUploadDTO>) criteria.setResultTransformer(Transformers.aliasToBean(FileUploadDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
