package com.pokemon.pokedex.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.User;

public interface UserDao extends CrudRepository<User, Integer>{
	
	Optional<User> findOneByEmail(String email);

}
