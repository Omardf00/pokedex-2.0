package com.pokemon.pokedex.service;

import com.pokemon.pokedex.dao.EvolutionFromDao;
import com.pokemon.pokedex.dao.PokemonDao;
import com.pokemon.pokedex.entity.EvolutionFrom;
import com.pokemon.pokedex.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvolutionFromServiceImpl implements EvolutionFromService {

    @Autowired
    EvolutionFromDao dao;

    @Override
    public List<EvolutionFrom> getEvolutionFroms() {
        return (List<EvolutionFrom>) dao.findAll();
    }

    @Override
    public List<Pokemon> getEvolutionsByOrigin(Pokemon pokemon) {
        List<EvolutionFrom> evolutionFroms = dao.findAllByOriginPokemon(pokemon);
        List<Pokemon> evolutions = new ArrayList<>();
        evolutionFroms.forEach(evolutionFrom -> evolutions.add(evolutionFrom.getEvolutionedPokemon()));
        return evolutions;
    }

    @Override
    public Pokemon getOriginByEvolution(Pokemon pokemon) {
        return dao.findByEvolutionedPokemon(pokemon).getOriginPokemon();
    }

    @Override
    public EvolutionFrom setEvolutionFrom(EvolutionFrom evolutionFrom) {
        return dao.save(evolutionFrom);
    }
}
