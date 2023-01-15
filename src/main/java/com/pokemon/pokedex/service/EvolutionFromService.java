package com.pokemon.pokedex.service;

import com.pokemon.pokedex.entity.EvolutionFrom;
import com.pokemon.pokedex.entity.Pokemon;

import java.util.List;

public interface EvolutionFromService {

    public List<EvolutionFrom> getEvolutionFroms();

    public List<Pokemon> getEvolutionsByOrigin(Pokemon pokemon);

    public Pokemon getOriginByEvolution(Pokemon pokemon);

    public EvolutionFrom setEvolutionFrom(EvolutionFrom evolutionFrom);

}
