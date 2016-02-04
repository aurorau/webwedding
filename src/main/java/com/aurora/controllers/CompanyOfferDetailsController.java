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
import com.aurora.model.CompanyOffers;
import com.aurora.service.CompanyOfferDetailsService;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;
import com.aurora.util.OfferDetailsDTO;

@Controller
@RequestMapping("/companyOfferDetailsController")
public class CompanyOfferDetailsController {
	 CompanyOfferDetailsService companyOfferDetailsService = null;

	 @Autowired
	 public void setCompanyOfferDetailsService(CompanyOfferDetailsService companyOfferDetailsService) {
		 this.companyOfferDetailsService = companyOfferDetailsService;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView companyOfferDetails() throws Exception {
		 return new ModelAndView("companyOffers");
	 }
	 @RequestMapping(method = RequestMethod.POST, value="/saveCompanyOffer")
	 public @ResponseBody JsonResponce saveCompanyOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = companyOfferDetailsService.saveCompanyOffer(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getAllActiveOffers")
	 public @ResponseBody JsonResponce getAllActiveOffers(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 List<CompanyOffers> list = null;
		 list= companyOfferDetailsService.getAllActiveOffers();
		 res.setResult(list);
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getOfferByCODID")
	 public @ResponseBody JsonResponce getOfferByCODID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 OfferDetailsDTO offerDetails = companyOfferDetailsService.getOfferByCODID(request);
		 
		 res.setStatus("success");
		 res.setResult(offerDetails);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/companyOfferDelete")
	 public @ResponseBody JsonResponce companyOfferDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= companyOfferDetailsService.companyOfferDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 @RequestMapping(method = RequestMethod.GET, value="/getCompanyOfferTable")
	 public ModelAndView getCompanyOfferTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_COMPANY_OFFER_DETAILS);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<OfferDetailsDTO> companyOfferDetailsList = (List<OfferDetailsDTO>) companyOfferDetailsService.getCompanyOfferTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int companyOfferDetailsCount = companyOfferDetailsService.getCompanyOfferTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, companyOfferDetailsCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_COMPANY_OFFER_DETAILS, companyOfferDetailsList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicCompanyOfferDetailsTable", model.asMap());
	 }
}
