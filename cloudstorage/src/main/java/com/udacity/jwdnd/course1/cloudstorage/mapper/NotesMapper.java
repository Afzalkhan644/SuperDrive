package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;

@Mapper
public interface NotesMapper {
	

	@Select("SELECT * FROM  NOTES")
    List<Notes> viewAllNotes();
	
    @Select("SELECT * FROM NOTES WHERE title = #{title}")
    Notes getNotes(String title);
	

	@Insert("INSERT INTO NOTES (title,description) VALUES(#{title},#{desciption},#{contenttype})")
	@Options(useGeneratedKeys=true,keyProperty="note_id")
	int addNotes(Notes notes);
}
