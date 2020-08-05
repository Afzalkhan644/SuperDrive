package com.udacity.jwdnd.course1.cloudstorage.model;


import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class Files {
    private int file_id;
	private String filename;
	private  String contenttype;
	private long fileSize;
	private byte[] filedata;
	private Integer user_id;
	
	
	public Files(int file_id, String filename, String contenttype, long fileSize, byte[] filedata, Integer user_id) {
		super();
		this.file_id = file_id;
		this.filename = filename;
		this.contenttype = contenttype;
		this.fileSize = fileSize;
		this.filedata = filedata;
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long l) {
		this.fileSize = l;
	}
	public byte[] getFiledata() {
		return filedata;
	}
	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	public Files() {
		
	}
	public Files(String filename, String contenttype, long fileSize, byte[] filedata) {

		this.filename = filename;
		this.contenttype = contenttype;
		this.fileSize = fileSize;
		this.filedata = filedata;
	}
	@Override
	public String toString() {
		return "Files [file_id=" + file_id + ", filename=" + filename + ", contenttype=" + contenttype + ", fileSize="
				+ fileSize + ", filedata=" + filedata + ", user_id=" + user_id + "]";
	}
	
	
	
	
	
}
