package com.telefonica.spring.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telefonica.spring.model.Movie;
import com.telefonica.spring.model.User;
import com.telefonica.spring.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/account")
	public ModelAndView getUser(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (StringUtils.isEmpty(session.getAttribute("email"))) {
			mav.setViewName("login");
			return mav;
		}
		User user = userRepository.findByEmail((String) session.getAttribute("email"));
		if (user != null) {
			mav.setViewName("user-edit");
			mav.addObject("user", user);
		}

		return mav;
	}

	@GetMapping("/login")
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, HttpSession session) {
		if (user == null || StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
			return "redirect:/login";
		}
		if (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
			session.setAttribute("email", user.getEmail());
			return "redirect:/movies";
		}else {
			return "redirect:/login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
