package com.pokemon.pokedex.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Integer>{
	
	public Pokemon findByName(String name);

}
