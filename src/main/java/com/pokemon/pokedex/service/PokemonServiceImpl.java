package com.pokemon.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.PokemonDao;
import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.Type;

@Service
public class PokemonServiceImpl implements PokemonService {
	
	@Autowired
	PokemonDao dao;

	@Override
	public Pokemon findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Pokemon> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Pokemon> findAllByType(Type type) {
		return dao.findAllByType(type);
	}

	@Override
	public Pokemon findByNumPokedex(int numPokedex) {
		return dao.findByNumPokedex(numPokedex);
	}

}
