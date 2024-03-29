package com.pokemon.pokedex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.entity.PokemonDetail;
import com.pokemon.pokedex.service.PokemonDetailService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v2/pokedex/pokemon")
@Tag(name = "Pokemon Deatils Services", description = "A list of the services related with the details of the pokemons")
public class PokemonDetailController {
	
	@Autowired
	PokemonDetailService pokemonDetailService;

	@Operation(description = "Returns the details of a pokemon")
	@GetMapping("/detailsByPokemon")
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

	@Operation(description = "Returns a list of all the pokemons with their details")
	@GetMapping("/details")
	public ResponseEntity<?> getAllPokemonDetails(){
		
		List<PokemonDetail> pokemons = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pokemons = pokemonDetailService.findAll();
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<PokemonDetail>>(pokemons, HttpStatus.OK);
		
	}

}
