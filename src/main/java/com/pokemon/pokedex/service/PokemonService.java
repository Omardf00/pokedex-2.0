package com.pokemon.pokedex.service;

import java.util.List;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.Type;

public interface PokemonService {
	
	public Pokemon findByName(String name);
	
	public List<Pokemon> findAll();
	
	public List<Pokemon> findAllByType(Type type);
	
	public Pokemon findByNumPokedex(int numPokedex);

}
