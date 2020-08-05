package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	NotesService notesService;
	@Autowired
	FileService fileService;
	@Autowired
	CredentialsService cs;
	@Autowired
	UserService us;
	
	@GetMapping
	public String show(Model model,Notes notes,Credentials credential, Authentication auth) {
		
		model.addAttribute("notelist",notesService.getAllNotes());
		System.out.print(notesService.getAllNotes());
		model.addAttribute("filelist", fileService.getFiles());
		User u=us.getUser(auth.getName());
		try {
			model.addAttribute("credlist",cs.getAllCredentials(u.getUserid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
}
