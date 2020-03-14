package com.feiraBrasil.IFeiraAPI.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.feiraBrasil.IFeiraAPI.enums.ProfileEnum;
import com.feiraBrasil.IFeiraAPI.model.User;

public class JwtUserFactory {
	 private JwtUserFactory() {
	    }

	    public static JwtUser create(User user) {
	        return new JwtUser(user.getId(), 
	        		user.getUsuario(), 
	        		user.getPassword(), 
	        		mapToGrantedAuthorities(user.getProfile())
	        );
	    }

	    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
	    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
	    		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
	    		return authorities ;
	    }
}
