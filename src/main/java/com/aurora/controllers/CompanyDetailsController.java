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

import com.aurora.model.CompanyDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.service.CompanyDetailsService;
import com.aurora.util.CompanyDetailsDTO;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/companyDetailsController")
public class CompanyDetailsController {
	 CompanyDetailsService companyDetailsService = null;

	 @Autowired
	 public void setCompanyDetailsService(CompanyDetailsService companyDetailsService) {
		 this.companyDetailsService = companyDetailsService;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView supplierCategory() throws Exception {
		 return new ModelAndView("companyDetails");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveCompanyDetails")
	 public @ResponseBody JsonResponce saveCompanyDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = companyDetailsService.saveCompanyDetails(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getAllCompaniesByCategory")
	 public @ResponseBody JsonResponce getAllCompaniesByCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();

		 List<CompanyDetails> list = null;
		 
		 list= companyDetailsService.getAllCompaniesByCategory(request);
		 
		 res.setResult(list);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getCompanyDetailsBySCDID")
	 public @ResponseBody JsonResponce getCompanyDetailsBySCDID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 CompanyDetailsDTO companyDetails = companyDetailsService.getCompanyDetailsBySCDID(request);
		 
		 res.setStatus("success");
		 res.setResult(companyDetails);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/companyDetailsDelete")
	 public @ResponseBody JsonResponce companyDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= companyDetailsService.companyDetailsDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getCompanyDetailsTable")
	 public ModelAndView getCompanyDetailsTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_COMPANY_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<CompanyDetails> companyDetailsList = companyDetailsService.getCompanyDetailsTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int companyDetailsCount = companyDetailsService.getCompanyDetailsTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, companyDetailsCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_COMPANY_DETAILS, companyDetailsList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicCompanyDetailsTable", model.asMap());
	 }
}
