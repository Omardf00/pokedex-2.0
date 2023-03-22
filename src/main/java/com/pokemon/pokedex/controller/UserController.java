package com.pokemon.pokedex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.User;
import com.pokemon.pokedex.responses.UserResponse;
import com.pokemon.pokedex.service.RoleService;
import com.pokemon.pokedex.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/pokedex/user")
@Tag(name = "User Services", description = "A list of the services related with the user's CRUD")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleService roleService;

	@Operation(description = "Returns a list of all the users")
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

	@Operation(description = "Returns a user by id")
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		
		User user;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			user = userService.findById(id);
			
			if(user == null) {
				response.put("error", "The user with the id " + id + " does't appear in the database");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}

	@Operation(description = "Creates a new user")
	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result){
		
		UserResponse createUserResponse = new UserResponse();
		User tmpUser = new User();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			//When making a new user we force it to be a normal user. An admin must change the role
			user.setRole(roleService.findById(3));
			
			if (result.hasErrors()) {
				response.put("message", "There's errors within the provided data");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}

			User searchUser = userService.findByEmail(user.getEmail());
			if(searchUser!=null) {
				response.put("message", "There's already an user with this email");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			String codedPasswd = encoder.encode(user.getPassword());
			user.setPassword(codedPasswd);
			
			tmpUser = userService.save(user);
			
			createUserResponse.setMessage("The user has successfully been created");
			createUserResponse.setUser(tmpUser);
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
	}

	@Operation(description = "Updates the information of an specific user")
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user, BindingResult result){
		
		UserResponse updateUserResponse = new UserResponse();
		User tmpUser = new User();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			if (user.getId() == 0) {
				response.put("error", "The id must be provided");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			tmpUser = userService.findById(user.getId());
			
			if (tmpUser == null) {
				response.put("error", "The user with the id " + user.getId() + " does't appear in the database");
				return new ResponseEntity<>(response, HttpStatus.FOUND);
			}
			
			if (result.hasErrors()) {
				response.put("error", "There's errors within the provided data");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			String codedPasswd = encoder.encode(user.getPassword());
			
			tmpUser.setName(user.getName());
			tmpUser.setEmail(user.getEmail());
			tmpUser.setPassword(codedPasswd);
			
			updateUserResponse.setUser(userService.save(tmpUser));
			updateUserResponse.setMessage("The user has successfuly been updated");
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(updateUserResponse, HttpStatus.OK);
	}

	@Operation(description = "Deletes a user from the database")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
		
		User tmpUser;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			tmpUser=userService.findById(id);
			
			if (tmpUser == null) {
				response.put("error", "The user with the id " + id + " does't appear in the database");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			userService.deleteById(id);
			
		} catch (DataAccessException e) {
			response.put("error", "We ran into a problem trying to access the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Error e) {
			response.put("error", "The user with the id " + id + " does't appear in the database");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The user has been successfully deleted");
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}

}
