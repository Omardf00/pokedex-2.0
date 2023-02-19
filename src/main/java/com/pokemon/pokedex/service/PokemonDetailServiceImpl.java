package com.pokemon.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.PokemonDetailDao;
import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;

@Service
public class PokemonDetailServiceImpl implements PokemonDetailService {
	
	@Autowired
	PokemonDetailDao dao;

	@Override
	public PokemonDetail findByPokemon(Pokemon pokemon) {
		return dao.findByPokemon(pokemon);
	}

	@Override
	public List<PokemonDetail> findAll() {
		return dao.findAll();
	}

}
