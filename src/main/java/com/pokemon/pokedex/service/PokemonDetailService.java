package com.pokemon.pokedex.service;

import java.util.List;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;

public interface PokemonDetailService {
	
	public PokemonDetail findByPokemon(Pokemon pokemon);
	
	public List<PokemonDetail> findAll();

}
