package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;

@Service
public class NotesService {
	
private	final Notes notes;
private final NotesMapper notesMapper;

	public NotesService(Notes notes, NotesMapper notesMapper) {
		this.notes=notes;
		this.notesMapper=notesMapper;
		
	}
	
	public void notesSave(Notes notes) {
		notesMapper.addNotes(notes);	
	}
	
	 public Notes getNotes(String title) {
		return notesMapper.getNotes(title);
	 
	 }
	 
	 public List<Notes> getAllNotes(){
		 
		 return notesMapper.viewAllNotes();
	 }

}
