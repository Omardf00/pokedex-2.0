package com.pokemon.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.EvolutionLevelDao;
import com.pokemon.pokedex.entity.EvolutionLevel;
import com.pokemon.pokedex.entity.Pokemon;

@Service
public class EvolutionLevelServiceImpl implements EvolutionLevelService{
	
	@Autowired
	EvolutionLevelDao dao;

	@Override
	public EvolutionLevel findByPokemon(Pokemon pokemon) {
		return dao.findByPokemon(pokemon);
	}

	@Override
	public List<EvolutionLevel> findAll() {
		return dao.findAll();
	}

}
