package com.pokemon.pokedex.service;

import java.util.List;

import com.pokemon.pokedex.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int id);
	
	public User save(User user);
	
	public void deleteById(int id);

}
