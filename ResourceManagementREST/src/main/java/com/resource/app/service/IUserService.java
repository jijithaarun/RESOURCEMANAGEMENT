package com.resource.app.service;

import java.util.List;

import com.resource.app.model.User;

public interface IUserService {
	
public User addUser(User user);
public List<User> listUser();
public User findUser(String userName,String password);
public User updateUser(User user);
public void deleteUser(Integer id);
public User findById(Integer id);
public void updateIsActive( Integer id);
}
