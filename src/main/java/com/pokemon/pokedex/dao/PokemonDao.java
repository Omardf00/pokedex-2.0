package com.pokemon.pokedex.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.Type;

public interface PokemonDao extends CrudRepository<Pokemon, Integer>{
	
	public List<Pokemon> findAll();
	
	public Pokemon findByName(String name);
	
	public List<Pokemon> findAllByType(Type type);
	
	public Pokemon findByNumPokedex(int numPokedex);
	
}
