package com.company.travelrequest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.travelrequest.model.User;
import com.company.travelrequest.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginForm(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam Long userId, @RequestParam String password,
			HttpSession session, Model model){
		User test = userService.loginUser(userId, password);
		
		if(test != null){
			session.setAttribute("loggedInUser", test);
			return "redirect:/";
		}else {
			model.addAttribute("loginFailed", "You've failed to login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    session.invalidate();
	    return "login";
	}
}
