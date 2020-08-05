package com.udacity.jwdnd.course1.cloudstorage.mapper;



	import java.util.List;

import org.apache.ibatis.annotations.Insert;
	import org.apache.ibatis.annotations.Mapper;
	import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.User;

	@Mapper
	public interface UserMapper {
	    @Select("SELECT * FROM USERS WHERE username = #{username}")
	    User getUser(String username);

	  

	    @Select("select * from users")
	    List<User> findAll();


	    @Select("select * from users where users.userid = #{id}")
	    User findOne(@Param("id") Integer id);

	    @Select("select * from users where users.username = #{userName}")
	    User findByUsername(String userName);


	    @Insert("insert into users (username,salt,password,firstname,lastname) values (#{user.username},#{user.salt},#{user.password},#{user.firstName},#{user.lastName})")
	    Integer insert(@Param("user") User user);
	    
	    
	    
	    
	}

