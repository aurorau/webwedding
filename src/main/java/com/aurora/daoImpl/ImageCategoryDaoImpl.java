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
import com.aurora.dao.ImageCategoryDao;
import com.aurora.model.ImageCategory;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.HibernateBase;
import com.aurora.util.ImageCategoryDTO;

@Repository("imageCategoryDao")
public class ImageCategoryDaoImpl extends HibernateBase implements ImageCategoryDao {

	public ImageCategory getImageCategoryByICID(Long icid) {
		ImageCategory imageCategory = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(ImageCategory.class);
			criteria.add(Restrictions.eq("ICID", icid));
	
			imageCategory = (ImageCategory) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return imageCategory;
	}

	public void saveImageCategory(ImageCategory imageCategory) {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(imageCategory);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<ImageCategoryDTO> getAllImageCategories() {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<ImageCategoryDTO> list = null;
		
		Criteria criteria = session.createCriteria(ImageCategory.class);
		         criteria.addOrder(Order.asc("icName"));
		         
 		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("ICID").as("ICID"))
				.add(Projections.property("icType").as("icType"))
				.add(Projections.property("icName").as("icName"))
				.add(Projections.property("imageTable.ITID").as("ITID")));
		list = (List<ImageCategoryDTO>) criteria.setResultTransformer(Transformers.aliasToBean(ImageCategoryDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public void imageCategoryDelete(Long icid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from ImageCategory where ICID= :id"; 
		session.createQuery(hql).setParameter("id", icid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<ImageCategoryDTO> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<ImageCategoryDTO> list = null;
		
		Criteria criteria = session.createCriteria(ImageCategory.class,"imageCategory")
				.createAlias("imageCategory.imageTable", "imageTable")
				.setFirstResult(start)
				.setMaxResults(gridTableSize);
		criteria.addOrder(Order.asc("icName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("icType", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("icName", searchq,MatchMode.ANYWHERE)));
		}
		
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("ICID").as("ICID"))
				.add(Projections.property("icType").as("icType"))
				.add(Projections.property("icName").as("icName"))
				.add(Projections.property("imageTable.ITID").as("ITID")));
/*				.add(Projections.property("imageTable.imageName").as("imageName"))
				.add(Projections.property("imageTable.imageType").as("imageType"))
				.add(Projections.property("imageTable.imageSize").as("imageSize"))
				.add(Projections.property("imageTable.imageContent").as("imageContent")));*/
		
		list = (List<ImageCategoryDTO>) criteria.setResultTransformer(Transformers.aliasToBean(ImageCategoryDTO.class)).list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public int getImageCategoryTableCount(String searchq) {
		
		Session session = getSession();
		session.getTransaction().begin();
		
		int totalRowCount =0;
		Criteria criteria = session.createCriteria(ImageCategory.class)
				.setProjection(Projections.count("ICID"));
		
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("icType", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("icName", searchq,MatchMode.ANYWHERE)));
		}
		
		Long value = (Long) criteria.uniqueResult();
		totalRowCount = Integer.valueOf(value.intValue());
		
		session.getTransaction().commit();
		session.close();
		
		return totalRowCount;
	}

}
