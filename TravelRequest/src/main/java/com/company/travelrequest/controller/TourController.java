package com.company.travelrequest.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.travelrequest.model.Tour;
import com.company.travelrequest.service.TourService;

@Controller
@RequestMapping("/tours")
public class TourController {
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);

	@Autowired
	TourService tourService;
	
	@RequestMapping(params = "add")
	public String addForm(Model model, Principal principal){
		model.addAttribute("tour", new Tour());
		model.addAttribute("loggedInUser", principal.getName());
		return "tour/add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveForm(@ModelAttribute("tour") @Valid Tour tour,
			BindingResult result, Model model){
		if(result.hasErrors()){
			//model.addAttribute("events", sellerService.getAllEvents());
			return "tour/add";
		}
		tourService.saveTour(tour);
		model.addAttribute("tour", tourService.findTour(tour.getId()));
		return "tour/add";
		
	}
}
