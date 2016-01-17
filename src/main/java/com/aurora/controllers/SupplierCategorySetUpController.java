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

import com.aurora.model.DistrictDetails;
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.SupplierCategoryService;
import com.aurora.util.Constant;
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
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAllCategories")
	 public @ResponseBody JsonResponce getAllCategories(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 List<SupplierCategory> list = null;
		 
		 list= supplierCategoryService.getAllCategories();
		 
		 res.setResult(list);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getSupplierCategoryBySCID")
	 public @ResponseBody JsonResponce getSupplierCategoryBySCID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 SupplierCategory supplierCategory = supplierCategoryService.getSupplierCategoryBySCID(request);
		 
		 res.setStatus("success");
		 res.setResult(supplierCategory);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/supplierCategoryDelete")
	 public @ResponseBody JsonResponce supplierCategoryDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= supplierCategoryService.supplierCategoryDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getSupplierCategoryTable")
	 public ModelAndView getSupplierCategoryTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_SUPPLIER_CATEGORY);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<SupplierCategory> supplierCategoryList = supplierCategoryService.getSupplierCategoryTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int supplierCategoryCount = supplierCategoryService.getSupplierCategoryTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, supplierCategoryCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_SUPPLIER_CATEGORY, supplierCategoryList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicSupplierCategoryTable", model.asMap());
	 }
}
