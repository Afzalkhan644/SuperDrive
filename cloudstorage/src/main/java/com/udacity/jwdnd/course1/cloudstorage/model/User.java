package com.udacity.jwdnd.course1.cloudstorage.model;

 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class User {

    private int userid;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;

    private String role;
    private List <Files> files;
    private List <Notes> notes;
    private List <Credentials> credentials;
    

    public Collection<GrantedAuthority> getAuthorities() {
        //make everyone ROLE_USER
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            //anonymous inner type
            public String getAuthority() {
                return "ROLE_USER";
            }
        };
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Files> getFiles() {
		return files;
	}

	public void setFiles(List<Files> files) {
		this.files = files;
	}

	public List<Notes> getNotes() {
		return notes;
	}

	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	
	
	public List<Credentials> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credentials> credentials) {
		this.credentials = credentials;
	}

	public User( String userName, String salt, String password, String firstName, String lastName) {
		
		this.username = userName;
		this.salt = salt;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public User(int userid, String userName, String salt, String password, String firstName, String lastName,
			String role, List<Files> files, List<Notes> notes) {
		super();
		this.userid = userid;
		this.username = userName;
		this.salt = salt;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.files = files;
		this.notes = notes;
	}

	public User() {
		
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + username + ", salt=" + salt + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", files=" + files
				+ ", notes=" + notes + "]";
	}


}
