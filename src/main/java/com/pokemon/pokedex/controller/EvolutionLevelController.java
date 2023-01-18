package com.pokemon.pokedex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokemon.pokedex.entity.EvolutionLevel;
import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.service.EvolutionLevelService;

import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/api/v2/pokedex/pokemon")
public class EvolutionLevelController {

	@Autowired
	EvolutionLevelService evolutionLevelService;

	@GetMapping("/evolutionLevel")
	public ResponseEntity<?> getEvolutionLevelByPokemon(@Valid @RequestBody Pokemon pokemon, BindingResult result) {

		EvolutionLevel evolutionLevel = new EvolutionLevel();
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			response.put("message", "The syntax of the body is not correct");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		try {

			evolutionLevel = evolutionLevelService.findByPokemon(pokemon);

			if (evolutionLevel == null) {

				response.put("error", "The pokemon " + pokemon.getName() + " is not in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}

		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(evolutionLevel, HttpStatus.OK);

	}

	@GetMapping("/allEvolutionLevels")
	public ResponseEntity<?> getAllEvolutionLevels() {

		List<EvolutionLevel> evolutionLevels = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();

		try {

			evolutionLevels = evolutionLevelService.findAll();

			if (evolutionLevels == null) {

				response.put("error", "There are no pokemons in the data base");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}

		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(evolutionLevels, HttpStatus.OK);
	}

}
