package com.pokemon.pokedex.service;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;

public interface PokemonDetailService {
	
	public PokemonDetail findByPokemon(Pokemon pokemon);

}
