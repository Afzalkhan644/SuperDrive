package com.udacity.jwdnd.course1.cloudstorage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@PostMapping
    public ModelAndView logout(HttpSession session, ModelMap model) {
        session.setAttribute("user", null);
        model.addAttribute("logoutSuccess", true);
        return new ModelAndView("login", model);
    }

}
