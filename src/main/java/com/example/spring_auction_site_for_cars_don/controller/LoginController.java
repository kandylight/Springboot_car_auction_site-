package com.example.spring_auction_site_for_cars_don.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_auction_site_for_cars_don.model.User;
import com.example.spring_auction_site_for_cars_don.service.UserService;

@Controller
public class LoginController {

	private static final String SESSION_ATTRIBUTE_USER = "user";

	@Autowired
	private UserService userService;

	@GetMapping("/Login")
	public String login() {
		return "login.jsp";
	}

	@PostMapping("/LoginSubmit")
	public ModelAndView loginSubmit(User user, ModelAndView modelAndView, HttpSession session) {
		User userFromDb = userService.getByUserNameAndPassword(user.getUsername(), user.getPassword());
		if (userFromDb == null) {
			modelAndView.addObject("message", "This user is not in the database");
			modelAndView.setViewName("login.jsp");
			return modelAndView;
		}
		modelAndView.addObject("name", userFromDb.getUsername());
		modelAndView.addObject("message", " Welcome to the Car-auction site");
		session.setAttribute(SESSION_ATTRIBUTE_USER, userFromDb);
		modelAndView.setViewName("WEB-INF/main.jsp");
		return modelAndView;
	}

}
