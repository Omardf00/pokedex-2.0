package com.pokemon.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.service.PokemonService;

@Controller
@RequestMapping("/api/v2/pokedex/pokemon")
public class PokemonController {
	
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getPokemon(@PathVariable("name") String name){
		return new ResponseEntity<Pokemon>(pokemonService.findByName(name), HttpStatus.OK);
	}

}
