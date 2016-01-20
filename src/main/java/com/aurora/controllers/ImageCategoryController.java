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

import com.aurora.model.ImageCategory;
import com.aurora.model.SupplierCategory;
import com.aurora.service.ImageCategoryService;
import com.aurora.util.Constant;
import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/imageCategoryController")
public class ImageCategoryController {
	 private ImageCategoryService imageCategoryService = null;
	 
	 @Autowired
	 public void setImageCategoryService(ImageCategoryService imageCategoryService) {
		 this.imageCategoryService = imageCategoryService;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView imageCategory() throws Exception {
		 return new ModelAndView("imageCategory");
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, value="/saveImageCategory")
	 public @ResponseBody JsonResponce saveImageCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status = imageCategoryService.saveImageCategory(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getAllImageCategories")
	 public @ResponseBody JsonResponce getAllImageCategories(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 List<ImageCategory> list = null;
		 
		 list= imageCategoryService.getAllImageCategories();
		 
		 res.setResult(list);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getImageCategoryByICID")
	 public @ResponseBody JsonResponce getImageCategoryByICID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 ImageCategory imageCategory = null;
		 imageCategory = imageCategoryService.getImageCategoryByICID(request);
		 if(imageCategory != null) {
			 res.setStatus(Constant.SUCCESS);
		 } else {
			 res.setStatus(Constant.FAIL);
		 }
		 res.setResult(imageCategory);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/imageCategoryDelete")
	 public @ResponseBody JsonResponce imageCategoryDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 
		 String status= imageCategoryService.imageCategoryDelete(request);
		 
		 res.setStatus(status);
		 
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/getImageCategoryTable")
	 public ModelAndView getImageCategoryTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Model model = new ExtendedModelMap();
		 ParamEncoder paramEncoder = new ParamEncoder(Constant.TABLE_IMAGE_CATEGORY);
		 
	    	try{
	    		String sortField = ServletRequestUtils.getStringParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_SORT));
	    		int order = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_ORDER), 0);
	    		int page = ServletRequestUtils.getIntParameter(request, paramEncoder.encodeParameterName(TableTagParameters.PARAMETER_PAGE), 0);
	    		int start = (page>0) ? (page - 1) * Constant.GRID_TABLE_SIZE : 0;
	    		String searchq = ServletRequestUtils.getStringParameter(request, Constant.PARAMETER_SEARCH);
			
	    		List<ImageCategory> imageCategoryList = imageCategoryService.getImageCategoryTable(sortField,order,start, Constant.GRID_TABLE_SIZE, searchq);
	    		int imageCategoryCount = imageCategoryService.getImageCategoryTableCount(searchq);
			
	    		request.setAttribute(Constant.TABLE_SIZE, imageCategoryCount );
	    		request.setAttribute(Constant.GRID_TABLE_SIZE_KEY, Constant.GRID_TABLE_SIZE);
	    		model.addAttribute(Constant.TABLE_IMAGE_CATEGORY, imageCategoryList);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
		 
		 
		 return new ModelAndView("dynamicTables/dynamicImageCategoryTable", model.asMap());
	 }
}
