package com.aurora.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aurora.dao.ImageTableDao;
import com.aurora.model.ImageTable;
import com.aurora.util.HibernateBase;

@Repository("imageTableDao")
public class ImageTableDaoImpl extends HibernateBase implements ImageTableDao {

	public ImageTable getImageDetailsByITID(Long itid) throws Exception{
		ImageTable imageTable = null;
		
		Session session = getSession();
		session.getTransaction().begin();
		
		Criteria criteria = session.createCriteria(ImageTable.class,"imageTable")
			.add(Restrictions.eq("imageTable.ITID", itid));
	
			imageTable = (ImageTable) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return imageTable;
	}

	public void saveImageTable(ImageTable imageTable) throws Exception{

		Session session = getSession();
		session.getTransaction().begin();
		session.saveOrUpdate(imageTable);
		session.getTransaction().commit();
		session.close();
	}

	public void imageTableDelete(Long itid) throws Exception{
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "delete from ImageTable where ITID= :id"; 
		session.createQuery(hql).setParameter("id", itid).executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		
	}

}
