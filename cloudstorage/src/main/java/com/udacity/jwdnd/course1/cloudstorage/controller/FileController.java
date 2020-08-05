package com.udacity.jwdnd.course1.cloudstorage.controller;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;



@Controller()
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;

	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file,Authentication auth,Notes notes) {
		fileService.SaveFile(file,auth);	
		return "redirect:/home";
	}

	
@RequestMapping(value="/delete")
public String delete(Model model,@RequestParam("filename") String filename)
{
   fileService.deleteFile(filename);
  // 
    model.addAttribute("filelist", fileService.getFiles());
    return "redirect:/home";
}
	
@RequestMapping(value = "/download")
public ResponseEntity<Resource> downloadFile(HttpServletRequest request,@RequestParam("filename") String filename){
    Files file = fileService.getAfile(filename);
    HttpHeaders header = new HttpHeaders();
    header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename());
    header.add("Cache-Control", "no-cache, no-store, must-revalidate");
    header.add("Pragma", "no-cache");
    header.add("Expires", "0");

    ByteArrayResource resource = new ByteArrayResource(file.getFiledata());

    return ResponseEntity.ok()
            .headers(header)
            .contentLength(file.getFileSize())
            .contentType(MediaType.parseMediaType(file.getContenttype()))
            .body(resource);
}
	
	
}
