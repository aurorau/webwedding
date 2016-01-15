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
import com.aurora.model.SupplierCategory;
import com.aurora.model.SupplierPersonalDetails;
import com.aurora.service.SupplierCategoryService;
import com.aurora.service.SupplierDetailsService;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/supplierDetailsController")
public class SupplierDetailsController {
	 
	 SupplierDetailsService supplierDetailsService = null;

	 
	 @Autowired
	 public void setSupplierDetailsService( SupplierDetailsService supplierDetailsService) {
		 this.supplierDetailsService = supplierDetailsService;
	 }
	 
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView supplierCategory() throws Exception {
		 return new ModelAndView("supplierDetails");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveSupplierDetails")
	 public @ResponseBody JsonResponce saveSupplierDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = supplierDetailsService.saveSupplierPersonalDetails(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAllSuppliers")
	 public @ResponseBody JsonResponce getAllSuppliers(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 List<SupplierPersonalDetails> list = null;
		 
		 list= supplierDetailsService.getAllSuppliers();
		 
		 res.setResult(list);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getSupplierPersonalDetailsBySPDID")
	 public @ResponseBody JsonResponce getSupplierPersonalDetailsBySPDID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 SupplierPersonalDetails SupplierPersonalDetails = supplierDetailsService.getSupplierPersonalDetailsBySPDID(request);
		 
		 res.setStatus("success");
		 res.setResult(SupplierPersonalDetails);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getSupplierDetailsTable")
	 public ModelAndView getSupplierDetailsTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_SUPPLIER_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<SupplierPersonalDetails> supplierPersonalDetailsList = supplierDetailsService.getSupplierPersonalDetailsable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int SupplierPersonalDetailsCount = supplierDetailsService.getSupplierPersonalDetailsCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, SupplierPersonalDetailsCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_SUPPLIER_DETAILS, supplierPersonalDetailsList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicSupplierDetailsTable", model.asMap());
	 }
}
