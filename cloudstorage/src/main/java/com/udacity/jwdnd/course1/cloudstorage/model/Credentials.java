package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Credentials {
	
	    
    private Integer credentialid;
	 private String url;
	 private String username;
	 private String key;
	 private String password;
	 private Integer user_id;
	  
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCredential_id() {
		return credentialid;
	}
	public void setCredential_id(Integer credential_id) {
		this.credentialid = credential_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Credentials() {
	}
	@Override
	public String toString() {
		return "Credentials [credential_id=" + credentialid + ", url=" + url + ", username=" + username + ", key="
				+ key + ", password=" + password + ", user_id=" + user_id + "]";
	}

	 
	 
	 
}
