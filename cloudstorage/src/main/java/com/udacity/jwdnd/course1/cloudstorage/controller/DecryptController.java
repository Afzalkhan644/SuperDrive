package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
@Controller
public class DecryptController {
	@Autowired
	CredentialsService  credentialService;


    @RequestMapping(value = "/decrypt-credential/{credentialid}")
    @ResponseBody
    public List<String> decryptCredential(@PathVariable("credentialid") Integer credentialid, HttpSession session,
                                          ModelMap model){
        return Arrays.asList(credentialService.getDecryptedPW(credentialid));
    }

}
