package com.udacity.jwdnd.course1.cloudstorage.controller;



import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        	  credential.setPass(credential.getPassword());
        	   
            credentialsService.addCredential(credential, superUser.getUserid());
        }
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteCredentials(@RequestParam("credusername") String credusername) {
       
            credentialsService.deleteCredential(credusername);
            return "redirect:/home";
       
    }
    
    @RequestMapping(value = "/decrypt-credential/{credentialid}")
    @ResponseBody
    public List<String> decryptCredential(@PathVariable("credentialid") Integer credentialid, HttpSession session,
                                          ModelMap model){
    	System.out.print("hello");
        return Arrays.asList(credentialsService.getDecryptedPW(credentialid));
    }
    
   
}
