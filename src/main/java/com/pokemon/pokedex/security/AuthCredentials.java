package com.pokemon.pokedex.security;

import com.pokemon.pokedex.entity.Role;

import lombok.Data;

@Data
public class AuthCredentials {
	
	private String email;
	private String password;
	private Role role;

}
