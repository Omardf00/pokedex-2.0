package com.pokemon.pokedex.controller;

import com.pokemon.pokedex.entity.EvolutionFrom;
import com.pokemon.pokedex.entity.Pokemon;
import com.pokemon.pokedex.service.EvolutionFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/api/v2/pokedex/pokemon")
public class EvolutionFromController {

    @Autowired
    EvolutionFromService evolutionFromService;

    @GetMapping("/evolutionFrom")
    public ResponseEntity<?> getEvolutionFroms() {
        return new ResponseEntity<>(evolutionFromService.getEvolutionFroms(), HttpStatus.OK);
    }

    @GetMapping("/evolution")
    public ResponseEntity<?> getEvolutionsByOrigin(@RequestBody Pokemon pokemon) {
        Map<String, Object> response = new HashMap<>();
        List<Pokemon> evolutions;
        try {
            evolutions = evolutionFromService.getEvolutionsByOrigin(pokemon);
            if (evolutions == null) {
                response.put("message", pokemon.getName() + " no tiene evolución");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            return new ResponseEntity<>(evolutions, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "No se han podido obtener las evoluciones");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/origin")
    public ResponseEntity<?> getOriginByEvolution(@RequestBody Pokemon pokemon) {
        Map<String, Object> response = new HashMap<>();
        Pokemon origin;
        try {
            origin = evolutionFromService.getOriginByEvolution(pokemon);
            if (origin == null) {
                response.put("message", pokemon.getName() + " no tiene prevolución");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            return new ResponseEntity<>(origin, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "No se ha podido obtener la prevolución");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/evolutionFrom")
    public ResponseEntity<?> setEvolutionFrom(@RequestBody EvolutionFrom evolutionFrom) {
        return new ResponseEntity<>(evolutionFromService.setEvolutionFrom(evolutionFrom), HttpStatus.OK);
    }
}
