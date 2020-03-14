package com.feiraBrasil.IFeiraAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feiraBrasil.IFeiraAPI.model.User;
import com.feiraBrasil.IFeiraAPI.repository.UserRepository;
import com.feiraBrasil.IFeiraAPI.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findByUsuario(String usuario) {
		Optional<User> user = this.userRepository.findByUsuario(usuario);
		return user;
	}

	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	public User findById(Long id) {		
		return this.userRepository.findById(id).get();
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public void delete(Long id) {
		this.userRepository.deleteById(id);	
	}

}

