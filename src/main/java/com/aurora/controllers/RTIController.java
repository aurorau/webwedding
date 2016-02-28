package com.aurora.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurora.util.JsonResponce;

@Controller
@RequestMapping("/RTIController")
public class RTIController {
	 @RequestMapping(method = RequestMethod.POST, value="/postEventDetails")
	 public  @ResponseBody JsonResponce postEventDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 String sessionId = null;
		 
		 sessionId = request.getParameter("sessionID");
		 
		 if(sessionId == null || sessionId.equalsIgnoreCase("")) {
			 sessionId = request.getSession().getId();
		 }
		 
		 
		 JsonResponce res= new JsonResponce();
		 
	     response.setHeader("Access-Control-Allow-Origin", "*");
	     response.setHeader("Access-Control-Allow-Methods", "POST");
	     response.setHeader("Access-Control-Max-Age", "3600");
	     response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		 String eventType = request.getParameter("eventType");
		 String orientation = request.getParameter("orientation");
		 String eventTriggeredTime = request.getParameter("eventTriggeredTime");
		 String coordinateX = request.getParameter("coordinateX");
		 String coordinateY = request.getParameter("coordinateY");
		 String screenWidth = request.getParameter("screenWidth");
		 String screenHeight = request.getParameter("screenHeight");
		 String tagName = request.getParameter("tagName");
		 String elementId = request.getParameter("elementId");
		 String elementHeight = request.getParameter("elementHeight");
		 String elementWidth = request.getParameter("elementWidth");
		 String elementOffsetTop = request.getParameter("elementOffsetTop");
		 String elementOffsetLeft = request.getParameter("elementOffsetLeft");
		 String elementClass = request.getParameter("elementClass");
		 String numberOfFingers = request.getParameter("numberOfFingers");
		 String scrollTopPx = request.getParameter("scrollTopPx");
		 String elementScrollTop = request.getParameter("elementScrollTop");
		 String viewportHeight = request.getParameter("viewportHeight");
		 String viewportWidth = request.getParameter("viewportWidth");
		 
		 System.out.println("//////////////////////////////////////////////////////");
		 System.out.println("eventType :"+eventType);
		 System.out.println("coordinateX :"+coordinateX);
		 System.out.println("coordinateY :"+coordinateY);
		 System.out.println("screenWidth :"+screenWidth);
		 System.out.println("screenHeight :"+screenHeight);
		 System.out.println("eventTriggeredTime :"+eventTriggeredTime);
		 System.out.println("orientation :"+orientation);

		 System.out.println("tagName :"+tagName);
		 System.out.println("elementId :"+elementId);
		 System.out.println("elementClass :"+elementClass);
		 System.out.println("elementHeight :"+elementHeight);
		 System.out.println("elementWidth :"+elementWidth);
		 System.out.println("elementOffsetTop :"+elementOffsetTop);
		 System.out.println("elementOffsetLeft :"+elementOffsetLeft);
		 System.out.println("numberOfFingers :"+numberOfFingers);
		 System.out.println("scrollTopPx :"+scrollTopPx);
		 System.out.println("elementScrollTop :"+elementScrollTop);
		 System.out.println("viewportHeight :"+viewportHeight);
		 System.out.println("viewportWidth :"+viewportWidth);
		 
		 //String res1 = saveSessionDetails(request, sessionId);
		 
		 //res.setStatus(res1);
		 res.setResult(sessionId);

		 
		 return res;
	 }
}
