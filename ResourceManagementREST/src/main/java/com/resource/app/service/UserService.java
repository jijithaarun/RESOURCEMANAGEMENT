package com.resource.app.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.User;
import com.resource.app.repository.IUserRepository;



@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Transactional
	@Override
	public User addUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public List<User> listUser() {
		return userRepo.listUser();
	}

	@Override
	public User findUser(String userName, String password) {
		return userRepo.findByUsernameAndPassword(userName, password);
	}

	@Override
	public User updateUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);

	}

	@Override
	public User findById(Integer id) {
		Optional<User> findUserId = userRepo.findById(id);
		User user = findUserId.isPresent() ? findUserId.get() : null;
		return user;
	}

	@Override
	public void updateIsActive(Integer id) {
		userRepo.save(id);
		
	}


}
