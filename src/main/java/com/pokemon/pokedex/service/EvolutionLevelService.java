package com.pokemon.pokedex.service;

import java.util.List;

import com.pokemon.pokedex.entity.EvolutionLevel;
import com.pokemon.pokedex.entity.Pokemon;

public interface EvolutionLevelService {
	
	public EvolutionLevel findByPokemon(Pokemon pokemon);
	
	public List<EvolutionLevel> findAll();
	
}
