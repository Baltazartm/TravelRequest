package com.company.travelrequest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.travelrequest.model.Tour;
import com.company.travelrequest.service.TourService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	HttpSession session;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	TourService tourService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
			
	@ModelAttribute("allTrips")
	public List<Tour> fetchAllTours(HttpSession session){
		return tourService.findAllTours();
//		if(session == null){
//			return tourService.findAllTours();
//		}else {
//			Object sess = session.getAttribute("loggedInUser");
//			return tourService.findAllTours(sess);
//		}
	}
	
	@ModelAttribute("submittedTrips")
	public List<Tour> fetchSubmittedTours(){
		return tourService.findSubmittedTours();
	}
	
}
