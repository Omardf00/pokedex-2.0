package com.pokemon.pokedex.service;

import com.pokemon.pokedex.entity.Pokemon;

public interface PokemonService {
	
	public Pokemon findByName(String name);

}
