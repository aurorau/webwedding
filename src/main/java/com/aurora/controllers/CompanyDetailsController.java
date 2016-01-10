package com.aurora.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.service.CompanyDetailsService;

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
}
