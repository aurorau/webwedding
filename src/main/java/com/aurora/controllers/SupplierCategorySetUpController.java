package com.aurora.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.aurora.service.SupplierCategoryService;
import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/supplierCategorySetUp")
public class SupplierCategorySetUpController {
	 SupplierCategoryService supplierCategoryService = null;

	 
	 @Autowired
	 public void setSupplierCategoryService(SupplierCategoryService supplierCategoryService) {
		 this.supplierCategoryService = supplierCategoryService;
	 }
	
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView supplierCategory() throws Exception {
		 return new ModelAndView("supplierCategorySetUp");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveSupplierCategory")
	 public @ResponseBody JsonResponce saveSupplierCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = supplierCategoryService.saveSupplierCategory(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
}
