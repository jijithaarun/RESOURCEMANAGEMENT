package com.resource.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.User;

public interface IUserRepository extends JpaRepositoryImplementation<User, Integer> {

	@Query("from User where userName=?1 and password=?2")
	User findByUsernameAndPassword(String userName, String password);

	@Query("from User where isActive='Y'")
	List<User> listUser();

	@Modifying
	@Query("update User set isActive='N' where id=?1")
	void save(Integer id);

	User findByUserName(String username);

}
