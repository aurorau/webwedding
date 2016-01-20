package com.aurora.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.model.AddDetails;
import com.aurora.model.ImageCategory;
import com.aurora.service.AddDetailsService;
import com.aurora.util.AddDetailsDTO;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/addDetailsController")
public class AddDetailsController {
	
	 private AddDetailsService addDetailsService = null;
	 
	 @Autowired
	 public void setAddDetailsService(AddDetailsService addDetailsService) {
		 this.addDetailsService = addDetailsService;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView addDetails() throws Exception {
		 return new ModelAndView("addDetails");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveAddDetails")
	 public @ResponseBody JsonResponce saveAddDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = addDetailsService.saveAddDetails(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAllAdds")
	 public @ResponseBody JsonResponce getAllAdds(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 List<AddDetails> list = null;
		 
		 list= addDetailsService.getAllAdds();
		 
		 res.setResult(list);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAddDetailsByAID")
	 public @ResponseBody JsonResponce getAddDetailsByAID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 AddDetails addDetails = null;
		 addDetails = addDetailsService.getAddDetailsByAID(request);
		 if(addDetails != null) {
			 res.setStatus(Constant.SUCCESS);
		 } else {
			 res.setStatus(Constant.FAIL);
		 }
		 res.setResult(addDetails);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/addDetailsDelete")
	 public @ResponseBody JsonResponce addDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= addDetailsService.addDetailsDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAddDetailTable")
	 public ModelAndView getAddDetailTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_ADD_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<AddDetails> addDetailsList = addDetailsService.getAddDetailTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int addDetailsCount = addDetailsService.getAddDetailTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, addDetailsCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_ADD_DETAILS, addDetailsList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicAddDetailsTable", model.asMap());
	 }
}
