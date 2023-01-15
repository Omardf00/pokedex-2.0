package com.pokemon.pokedex.dao;

import com.pokemon.pokedex.entity.EvolutionFrom;
import com.pokemon.pokedex.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvolutionFromDao extends CrudRepository<EvolutionFrom, Integer>{
	public List<EvolutionFrom> findAllByOriginPokemon(Pokemon pokemon);
	public EvolutionFrom findByEvolutionedPokemon(Pokemon pokemon);
}
