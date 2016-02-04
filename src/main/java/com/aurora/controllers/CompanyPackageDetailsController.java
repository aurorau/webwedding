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
import com.aurora.model.CompanyPackageDetails;
import com.aurora.service.CompanyPackageDetailsService;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;
import com.aurora.util.PackageDetailsDTO;

@Controller
@RequestMapping("/companyPackageDetailsController")
public class CompanyPackageDetailsController {
	CompanyPackageDetailsService companyPackageDetailsService = null;

	 @Autowired
	 public void setCompanyPackageDetailsService(CompanyPackageDetailsService companyPackageDetailsService) {
		 this.companyPackageDetailsService = companyPackageDetailsService;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView companyPackageDetails() throws Exception {
		 return new ModelAndView("companyPackageDetails");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveCompanyPackage")
	 public @ResponseBody JsonResponce saveCompanyPackage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = companyPackageDetailsService.saveCompanyPackage(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAllActivePackages")
	 public @ResponseBody JsonResponce getAllActivePackages(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 List<CompanyPackageDetails> list = null;
		 list= companyPackageDetailsService.getAllActivePackages();
		 res.setResult(list);
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getPackageByCPDID")
	 public @ResponseBody JsonResponce getPackageByCPDID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 PackageDetailsDTO packageDetails = companyPackageDetailsService.getPackageByCPDID(request);
		 
		 res.setStatus("success");
		 res.setResult(packageDetails);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/companyPackageDelete")
	 public @ResponseBody JsonResponce companyPackageDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= companyPackageDetailsService.companyPackageDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getCompanyPackageTable")
	 public ModelAndView getCompanyPackageTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_COMPANY_PACKAGE_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<PackageDetailsDTO> companyPackageDetailsList = (List<PackageDetailsDTO>) companyPackageDetailsService.getCompanyPackageTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int companyPackageDetailsCount = companyPackageDetailsService.getCompanyPackageTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, companyPackageDetailsCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_COMPANY_PACKAGE_DETAILS, companyPackageDetailsList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicCompanyPackageDetailsTable", model.asMap());
	 }
}
