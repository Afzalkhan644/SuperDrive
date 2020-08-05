package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;




@Mapper
public interface CredentialsMapper {

	 @Select("SELECT * FROM CREDENTIALS")
	    List<Credentials> findAll();

	    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
	    public Credentials findOne(int credentialid);

	    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
	    public List<Credentials> findByUserId(int userid);

	    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) VALUES (#{credential.url}, #{credential.username}, #{credential.key}, #{credential.password}, #{userid})")
	    public int insertCredentials(@Param("credential") Credentials credential, int userid);

	    @Delete("DELETE FROM CREDENTIALS WHERE username = #{credusername}")
	    public int deleteCredentials(String credusername);

	    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, key = #{key}, password = #{password} WHERE credentialid = #{credentialid}")
	    public int updateCredentials(Credentials credential);

	}


