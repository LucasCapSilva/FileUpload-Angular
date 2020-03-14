package com.feiraBrasil.IFeiraAPI.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.feiraBrasil.IFeiraAPI.jwt.JwtUserFactory;
import com.feiraBrasil.IFeiraAPI.model.User;
import com.feiraBrasil.IFeiraAPI.service.UserService;


@Service
public class JwtUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

    		User user = userService.findByUsuario(usuario).get();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", usuario));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
