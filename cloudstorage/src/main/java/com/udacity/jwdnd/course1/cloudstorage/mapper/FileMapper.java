package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;



@Mapper
public interface FileMapper {
	@Select("SELECT * FROM  FILES")
    List<Files> viewAllFile();
	
    @Select("SELECT * FROM FILES WHERE user_id = #{user_id}")
    Files getFile(int user_id);
	

	@Insert("INSERT INTO FILES (filename,contenttype,fileSize,filedata,userid) VALUES(#{filename},#{contenttype},#{fileSize},#{filedata},#{user_id})")
	int addMessage(Files files);
	
	
    @Select("SELECT * FROM FILES WHERE filename = #{filename}")
    Files getAFile(String filename);
	
	@Delete("DELETE FROM FILES WHERE filename=#{filename}")
	void deleteFile(String filename);
	
	

} 
