package com.pokemon.pokedex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.Type;
import com.pokemon.pokedex.service.PokemonService;

import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v2/pokedex/pokemon")
public class PokemonController {
	
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getPokemon(@PathVariable("name") String name){
		
		Pokemon pokemon = new Pokemon();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pokemon = pokemonService.findByName(name);
			
			if(pokemon == null) {
				response.put("message", "The pokemon called " + name + " does not appear in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pokemon, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getPokemons(){
		
		List<Pokemon> pokemons;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pokemons = pokemonService.findAll();
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pokemons, HttpStatus.OK);
	}
	
	@GetMapping("/pokemonByType")
	public ResponseEntity<?> getPokemonsByType(@Valid @RequestBody Type type, BindingResult result){
		
		List<Pokemon> pokemons;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			response.put("message", "The syntax of the body is not correct");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			pokemons = pokemonService.findAllByType(type);
			
			if(pokemons == null) {
				response.put("message", "The type " + type + " does no appear in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pokemons, HttpStatus.OK);
		
	}
	
	@GetMapping("/pokemonById/{id}")
	public ResponseEntity<?> getPokemonById(@PathVariable("id") int numPokedex){
		
		Pokemon pokemon;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pokemon = pokemonService.findByNumPokedex(numPokedex);
			
			if (pokemon == null) {
				
				response.put("message", "The pokemon with the id " + numPokedex + " does not appear in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
				
			}
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(pokemon, HttpStatus.OK);
		
	}

}
