package com.udacity.jwdnd.course1.cloudstorage.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.services.FileService;


//
@Controller()
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;

	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file,Authentication auth,Model model) {
	
	//System.out.println(file.getOriginalFilename()+"1");
		fileService.SaveFile(file,auth);
		model.addAttribute("filelist", fileService.getFiles());
		return "home";
	}

	
@RequestMapping(value="/delete")
public String delete(Model model,@RequestParam("filename") String filename)
{
   fileService.deleteFile(filename);
   System.out.print("Chala");
    model.addAttribute("filelist", fileService.getFiles());
    return "home";
}
	

	
	
}
