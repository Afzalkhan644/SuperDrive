package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;

@Controller
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    @Autowired
    private User user;
    @GetMapping()
    public String showNotes(Notes notes) {
    	
    	
    	return "home";
    	
    	
    }
    
    
    @PostMapping
    public String notesSave(Notes notes, Model model)
    {
    	notes.setUser_id(user.getUser_id());
    	notesService.notesSave(notes);
    	model.addAttribute("NotesList",notesService.getAllNotes());
    	return "home";
    }

  
        


}
