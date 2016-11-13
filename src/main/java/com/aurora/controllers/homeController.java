package com.aurora.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.util.JsonResponce;

@Controller
public class homeController {
	
	public static String status = null;
	
	 @RequestMapping(method = RequestMethod.GET, value="/")
	 public ModelAndView homePage() throws Exception {
		 return new ModelAndView("webwedding");
	 }
	 
/*	 @RequestMapping(method = RequestMethod.POST, value="/JSorCSSDisabled")
	 public @ResponseBody JsonResponce JSorCSSDisabled(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 status = ServletRequestUtils.getStringParameter(request, "type");
		 JsonResponce res= new JsonResponce();
		 res.setStatus(status);
		 return res;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value="/JSorCSSDisabledStatus")
	 public @ResponseBody JsonResponce JSorCSSDisabledStatus(HttpServletResponse response) throws Exception {
		 JsonResponce res= new JsonResponce();
		 res.setStatus(status);
		 return res;
	 }*/
	 
}
