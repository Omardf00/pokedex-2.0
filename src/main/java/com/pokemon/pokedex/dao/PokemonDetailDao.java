package com.pokemon.pokedex.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;

public interface PokemonDetailDao extends CrudRepository<PokemonDetail, Pokemon>{
	
	public PokemonDetail findByPokemon(Pokemon pokemon);

}
