package com.pokemon.pokedex.responses;

import com.pokemon.pokedex.entity.User;

import lombok.Data;

@Data
public class UserResponse {
	
	private User user;
	
	private String message;

}
