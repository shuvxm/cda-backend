package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.User;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserDao 
{

	User saveUser(User user);

	List<User> findAllUsers();

	Optional<User> findUserById(int id);

	Optional<User> findByUsernameAndPassword(String username, String password);

}

