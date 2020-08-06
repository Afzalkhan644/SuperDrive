package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    @Autowired
    private User user;
    @Autowired
    private UserService us;
    
    
    @GetMapping()
    public String showNotes(Notes notes) {  	
    	return "home";
    }
    
    
    @PostMapping
    public String notesSave(Notes notes, Model model,Authentication authentication )
    {
    	
    	   User superUser= us.getUser( authentication.getName());
    	   if (notes.getNoteid() > 0) {
    		   notesService.update(notes);
    		   
    	   }
    	   else {
    		   notes.setUserid(superUser.getUserid());
    	notesService.notesSave(notes);
    	}
    	   
    	   return "redirect:/result?success";	
    }

    @RequestMapping(value="/delete")
    public String delete(Model model,@RequestParam("notename") String notename)
    {
    	notesService.deleteNote(notename);
    	 return "redirect:/result?success";	
    }
  
        


}
