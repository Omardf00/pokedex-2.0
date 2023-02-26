package com.pokemon.pokedex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.UserDao;
import com.pokemon.pokedex.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = dao.findOneByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe")); 
		
		return new UserDetailsImpl(user);
	}

}
