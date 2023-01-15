package com.pokemon.pokedex.controller;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.service.EvolutionFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v2/pokedex/pokemon")
public class EvolutionFromController {

    @Autowired
    EvolutionFromService evolutionFromService;

    @GetMapping("/evolution")
    public ResponseEntity<?> getEvolutionsByPokemon(@RequestBody Pokemon pokemon) {
        return new ResponseEntity<>(evolutionFromService.getEvolutionsByPokemon(pokemon), HttpStatus.OK);
    }
}
