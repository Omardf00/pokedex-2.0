package com.pokemon.pokedex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.EvolutionFromDao;
import com.pokemon.pokedex.entity.EvolutionFrom;
import com.pokemon.pokedex.entity.Pokemon;

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
        if (evolutionFroms.isEmpty()) return null;
        List<Pokemon> evolutions = new ArrayList<>();
        evolutionFroms.forEach(evolutionFrom -> evolutions.add(evolutionFrom.getEvolutionedPokemon()));
        return evolutions;
    }

    @Override
    public Pokemon getOriginByEvolution(Pokemon pokemon) {
        try {
            return dao.findByEvolutionedPokemon(pokemon).getOriginPokemon();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EvolutionFrom setEvolutionFrom(EvolutionFrom evolutionFrom) {
        return dao.save(evolutionFrom);
    }
}
