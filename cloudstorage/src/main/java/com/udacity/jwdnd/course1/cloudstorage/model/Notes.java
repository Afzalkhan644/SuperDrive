package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.stereotype.Component;

@Component
public class Notes {
private int note_id;
private String title;
private String description;
private int  user_id;


public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getNote_id() {
	return note_id;
}
public void setNote_id(int note_id) {
	this.note_id = note_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Notes() {

}
public Notes(int note_id, String title, String description) {
	super();
	this.note_id = note_id;
	this.title = title;
	this.description = description;
}
public Notes(String title, String description, int user_id) {
	super();
	this.title = title;
	this.description = description;
	this.user_id = user_id;
}


}
