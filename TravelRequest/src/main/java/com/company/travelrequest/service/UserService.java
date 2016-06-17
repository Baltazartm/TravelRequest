package com.company.travelrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.travelrequest.dao.UserDao;
import com.company.travelrequest.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public long countAllUsers(){
		return userDao.countUsers();
	}
	
	public User findUser(Long id){
		return userDao.findUser(id);
	}
	
	public User findUser(String name){
		User found = userDao.findUserByNameEquals(name).getSingleResult();
		return found;
	}
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
	
	public List<User> findUserEntries(int firstResult, int maxResults){
		return userDao.findUserEntries(firstResult, maxResults);
	}
	
	public User loginUser(Long userId, String password){
		User user = this.findUser(userId);
		
		if(user != null && user.getPassword().equals(password)){
			return user;
		}else {
			return null;
		}
	}
}
