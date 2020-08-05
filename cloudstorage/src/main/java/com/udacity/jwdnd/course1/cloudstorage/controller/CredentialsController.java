package com.udacity.jwdnd.course1.cloudstorage.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller()
@RequestMapping("/credentials")
public class CredentialsController {
	

    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private UserService us;

    @PostMapping
    public String saveOrUpdateCredentials(Authentication authentication, Credentials credential) {
    	
      User superUser= us.getUser( authentication.getName());
        if (credential.getCredential_id() > 0) {
        //	System.out.print("hello");
            credentialsService.updateCredential(credential);
        }
        else {
            credentialsService.addCredential(credential, superUser.getUserid());
        }
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteCredentials(@RequestParam("credusername") String credusername) {
       
            credentialsService.deleteCredential(credusername);
            return "redirect:/home";
       
    }
	

}
