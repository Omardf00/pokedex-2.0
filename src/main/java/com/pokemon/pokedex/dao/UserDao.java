package com.pokemon.pokedex.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.User;

public interface UserDao extends CrudRepository<User, Integer>{

}
