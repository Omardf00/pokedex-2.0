package com.pokemon.pokedex.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;

public interface PokemonDetailDao extends CrudRepository<PokemonDetail, Integer>{
	
	public PokemonDetail findByPokemon(Pokemon pokemon);
	
	public List<PokemonDetail> findAll();

}
