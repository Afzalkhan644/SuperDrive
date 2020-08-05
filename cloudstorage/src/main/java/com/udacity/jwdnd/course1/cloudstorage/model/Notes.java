package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class Notes {
private Integer noteid;
private String notetitle;
private String notedescription;



public String getNotedescription() {
	return notedescription;
}
public void setNotedescription(String notedescription) {
	this.notedescription = notedescription;
}

public String getNotetitle() {
	return notetitle;
}
public void setNotetitle(String notetitle) {
	this.notetitle = notetitle;
}

private Integer  userid;
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer user_id) {
	this.userid = user_id;
}

public Integer getNoteid() {
	return noteid;
}
public void setNoteid(Integer noteid) {
	this.noteid = noteid;
}
public Notes() {

}
public Notes(Integer note_id, String title, String description) {
	super();
	this.noteid = note_id;
	this.notetitle = title;
	this.notedescription = description;
}
public Notes(String title, String description, Integer user_id) {
	super();
	this.notetitle = title;
	this.notedescription = description;
	this.userid = user_id;
}



}
