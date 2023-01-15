package com.pokemon.pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.PokemonDao;
import com.pokemon.pokedex.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
	PokemonDao dao;

	@Override
	public Pokemon findByName(String name) {
		return dao.findByName(name);
	}

}
