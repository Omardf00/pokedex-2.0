package com.pokemon.pokedex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.User;
import com.pokemon.pokedex.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/pokedex/user")
@Tag(name = "User Services", description = "A list of the services related with the user's CRUD")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
		
		List<User> users;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			users = userService.findAll();
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
		
		User user;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			user = userService.findById(id);
			
			if(user == null) {
				response.put("message", "The user with the id " + id + " does't appear in the database");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		}catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result){
		
		User userResponse;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			if (result.hasErrors()) {
				response.put("message", "There's error within the provided data");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			user = userService.save(user);
			
		}catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
	}

}
