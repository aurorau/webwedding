package com.aurora.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.aurora.dao.DistrictDetailsDao;
import com.aurora.model.DistrictDetails;
import com.aurora.service.DistrictDetailsService;
import com.aurora.util.Constant;

@Service("districtDetailsService")
public class DistrictDetailsServiceImpl implements DistrictDetailsService {

	private DistrictDetailsDao districtDetailsDao = null;
	
	@Autowired
	public void setDistrictDetailsDao(DistrictDetailsDao districtDetailsDao) {
		this.districtDetailsDao = districtDetailsDao;
	}
	
	public List<DistrictDetails> getDistrictDetailsTable(String serchq) {
		List<DistrictDetails>  list =null;
		try {
			list = districtDetailsDao.getDistrictDetailsTable(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		return list;
	}

	public int getDistrictDetailsTableCount(String serchq) {
		int count = 0;
		
		try {
			count = districtDetailsDao.getDistrictDetailsTableCount(serchq);
		}catch (Exception e){
			System.out.println("Error :"+e);
		}
		
		return count;
	}

	public String saveDistrictDetails(HttpServletRequest request) {
		String status = null;
		DistrictDetails districtDetails = null;
		Long ddid = null;
		try {

			ddid = ServletRequestUtils.getLongParameter(request, "hiddenDDID",0L);
			Boolean isNew = (ddid == 0); 
			
			if(isNew) {
				districtDetails = new DistrictDetails();
				status = Constant.SAVED;
			} else {
				districtDetails = districtDetailsDao.getDistrictDetailsByDDID(ddid);
				status = Constant.UPDATED;
			}
			
			districtDetails.setDistrictCode(ServletRequestUtils.getStringParameter(request, "districtCode"));
			districtDetails.setDistrictName(ServletRequestUtils.getStringParameter(request, "districtName"));
			
			districtDetailsDao.saveDistrictDetails(districtDetails);
			
		}catch(Exception e) {
			status = Constant.FAIL;
			System.out.println(e);
		}
		return status;
	}

}