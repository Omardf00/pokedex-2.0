package com.pokemon.pokedex.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.EvolutionLevel;
import com.pokemon.pokedex.entity.Pokemon;

public interface EvolutionLevelDao extends CrudRepository<EvolutionLevel, Integer>{
	
	public EvolutionLevel findByPokemon(Pokemon pokemon);
	
	public List<EvolutionLevel> findAll();

}
