package com.webapp.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import com.webapp.springboot.thymeleafdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.springboot.thymeleafdemo.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAllByOrderByUsernameAsc();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// user not found
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}

}






