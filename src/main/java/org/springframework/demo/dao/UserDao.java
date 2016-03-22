package org.springframework.demo.dao;

import java.util.List;

import org.springframework.demo.model.User;

/**
 * This is an Interface Class for Implementation of Data Access
 * @author 
 *
 */
public interface UserDao {  
	List<User> getAllUser(); 
	public User getUser(int id);
	public void addUser(User user);
	public void updateUser(int id, User user);
	public void deleteUser(int id);
	
	}  