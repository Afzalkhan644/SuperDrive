package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;

@Mapper
public interface NotesMapper {
	

	@Select("SELECT * FROM  NOTES")
    List<Notes> viewAllNotes();
	
    @Select("SELECT * FROM NOTES WHERE title = #{title}")
    Notes getNotes(String title);
	

	@Insert("INSERT INTO NOTES (notetitle,notedescription,userid)VALUES(#{notes.notetitle},#{notes.notedescription},#{notes.userid})")
	int addNotes(@Param("notes")Notes notes);

	@Delete("DELETE FROM NOTES WHERE notetitle = #{notename}")
	public void delete(String notename);


@Update("UPDATE notes SET notetitle = #{note.notetitle}, notedescription = #{note.notedescription} WHERE noteid = #{note.noteid}")
Integer updateNote(@Param("note") Notes note);
  
}