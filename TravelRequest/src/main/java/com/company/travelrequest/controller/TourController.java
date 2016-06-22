package com.company.travelrequest.controller;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.travelrequest.model.Tour;
import com.company.travelrequest.model.User;
import com.company.travelrequest.service.TourService;
import com.company.travelrequest.service.UserService;

@Controller
@RequestMapping("/tours")
public class TourController {
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);

	@Autowired
	TourService tourService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(params = "add", method = RequestMethod.GET)
	public String addForm(Model model, Principal principal){
		model.addAttribute("tour", new Tour());
		model.addAttribute("manager", userService.findAllUsers());
//		model.addAttribute("loggedInUser", principal.getName());
		return "tour/add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveForm(@ModelAttribute("tour") @Valid Tour tour,
			BindingResult result, Model model){
		if(result.hasErrors()){
			//model.addAttribute("events", sellerService.getAllEvents());
			System.out.println("error inserting");
			return "tour/add";
		}
		tourService.saveTour(tour);
		model.addAttribute("trip", tourService.findTour(tour.getId()));
		System.out.println("success inserting " + tour.getId());
		return "redirect: tours/"+tour.getId();
		
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") Long formId,
			Model model){
		model.addAttribute("trips", tourService.findTour(formId));
		model.addAttribute("manager", userService.findAllUsers());
		return "tour/edit";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateForm(@PathVariable("id") @ModelAttribute("tour") @Valid Tour tour,
			BindingResult result){
		if(result.hasErrors()){
			System.out.println("failed to edit..");
			return "tour/add";
		}
		tourService.editTour(tour);
		System.out.println("edited..");
		return "redirect:/tours/";
	}
	
	@RequestMapping(value ="/{id}")
	public ModelAndView getTrip(@PathVariable("id") Long tourId){
		Tour tour = tourService.findTour(tourId);
		return new ModelAndView("tour/view", "tour", tour);
	}
}
