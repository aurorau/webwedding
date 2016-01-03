package com.aurora.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.aurora.service.DistrictDetailsService;
import com.aurora.util.JsonResponce;


@Controller
@RequestMapping("/districtSetUp")
public class DistrictSetUpController {
	
	 DistrictDetailsService districtDetailsService = null;

	 
	 @Autowired
	 public void setDistrictDetailsService(DistrictDetailsService districtDetailsService) {
		 this.districtDetailsService = districtDetailsService;
	 }
	
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView districtDetails() throws Exception {
		 return new ModelAndView("districtSetUp");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveDistrictDetails")
	 public @ResponseBody JsonResponce saveDistrictDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = districtDetailsService.saveDistrictDetails(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 //@RequestMapping(method = RequestMethod.GET, value="/getDistrictDetailsTable")
/*	 public ModelAndView getDistrictDetailsTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_DISTRICT);
		 
	    	try{
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		//List<DistrictDetails> districtList = employeeprofileManager.searchEmployees(start, Constant.GRID_TABLE_SIZE, searchq);
	    		//int districtCount = employeeprofileManager.searchEmployeeCount(searchq);
			
	    		//System.out.println(employeeProfileGridModel.size());
			
	    		//request.setAttribute(Constant.TABLE_SIZE, districtCount );
	    		//request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		//model.addAttribute(Constant.TABLE_DISTRICT, districtList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("ajax/employeeProfileTable", model.asMap());
	 }*/
	 
	 
}
