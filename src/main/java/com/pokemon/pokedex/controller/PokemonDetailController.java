package com.pokemon.pokedex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;
import com.pokemon.pokedex.service.PokemonDetailService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/v2/pokedex/pokemon")
public class PokemonDetailController {
	
	@Autowired
	PokemonDetailService pokemonDetailService;
	
	@GetMapping("/details")
	public ResponseEntity<?> getPokemonDetails(@Valid @RequestBody Pokemon pokemon, BindingResult result){
		
		PokemonDetail pokemonFinal = new PokemonDetail();
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			response.put("message", "The syntax of the body is not correct");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		}
		
		try {
			
			pokemonFinal = pokemonDetailService.findByPokemon(pokemon);
			
			if(pokemonFinal==null) {
				response.put("message", "The pokemon " + pokemon.getName() + " does no appear in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pokemonFinal, HttpStatus.OK);
	}

}
