package com.aurora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backOffice")
public class BackOfficeController {
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView backOffice() throws Exception {
		 return new ModelAndView("w2BackOffice");
	 }
}
