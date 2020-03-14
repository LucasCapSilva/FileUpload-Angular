package com.feiraBrasil.IFeiraAPI.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.feiraBrasil.IFeiraAPI.model.User;
import com.feiraBrasil.IFeiraAPI.model.CurrentUser;
import com.feiraBrasil.IFeiraAPI.model.JwtAuthentication;

import com.feiraBrasil.IFeiraAPI.jwt.JwtTokenUtil;
import com.feiraBrasil.IFeiraAPI.service.UserService;



@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;	
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user){		
		Optional<User> userExist = userService.findByUsuario(user.getUsuario());
		if (userExist.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					"Usuario ja contem na base, por favor tente outro");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.createOrUpdate(user);
		
		return user;		
	}
	
	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthentication jwtAuthenticarion){
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtAuthenticarion.getUsuario(), 
						jwtAuthenticarion.getPassword()
						)
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticarion.getUsuario());
		final User user = userService.findByUsuario(jwtAuthenticarion.getUsuario()).get();
		final String token = jwtTokenUtil.generateToken(userDetails);
		user.setPassword(null);
		
		return ResponseEntity.ok(new CurrentUser(token, user));
	}
	

}
