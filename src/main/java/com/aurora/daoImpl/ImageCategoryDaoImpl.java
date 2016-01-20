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
import com.aurora.dao.ImageCategoryDao;
import com.aurora.model.ImageCategory;
import com.aurora.util.HibernateBase;

@Repository("imageCategoryDao")
public class ImageCategoryDaoImpl extends HibernateBase implements ImageCategoryDao {

	@Transactional
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

	@Transactional
	public void saveImageCategory(ImageCategory imageCategory) {
		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(imageCategory);
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public List<ImageCategory> getAllImageCategories() {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<ImageCategory> list = null;
		
		Criteria criteria = session.createCriteria(ImageCategory.class);
		         criteria.addOrder(Order.asc("icName"));
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Transactional
	public void imageCategoryDelete(Long icid) {
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from ImageCategory where ICID= :id"; 
		session.createQuery(hql).setParameter("id", icid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public List<ImageCategory> getImageCategoryTable(String sortField, int order, int start, int gridTableSize,String searchq) {
		Session session = getSession();
		session.getTransaction().begin();
		
		List<ImageCategory> list = null;
		
		Criteria criteria = session.createCriteria(ImageCategory.class)
				.setFirstResult(start)
				.setMaxResults(gridTableSize);
		criteria.addOrder(Order.asc("icName"));
		if(!searchq.isEmpty()) {
			criteria.add(Restrictions.disjunction()
			        .add(Restrictions.ilike("icType", searchq, MatchMode.ANYWHERE))
			        .add(Restrictions.ilike("icName", searchq,MatchMode.ANYWHERE)));
		}
		list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Transactional
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
