package com.udacity.jwdnd.course1.cloudstorage.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Service
public class FileService {
	
	@Autowired
	private FileMapper mapper;
	@Autowired
	private Files newFile;
	
	@Autowired
	private UserMapper um;
	
public List<Files> getFiles(){
	
	return mapper.viewAllFile();
}

	
	
	public void SaveFile(MultipartFile file, Authentication auth)
	{
		User u=um.getUser(auth.getName());
	//	System.out.print("user id"+u.getUser_id());
		newFile.setUser_id(u.getUserid());
		newFile.setContenttype(file.getContentType());
		newFile.setFilename(file.getOriginalFilename());
		try {
			newFile.setFiledata(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newFile.setFileSize(file.getSize());
		mapper.addMessage(newFile);

	}
	
	public void deleteFile(String file) {
		mapper.deleteFile(file);
		
	}




public Files getAfile(String filename) {
	// TODO Auto-generated method stub
	return mapper.getAFile(filename);
}

public Files getfilebyID(int id) {
	return mapper.getFile(id);
	
}
	
}
