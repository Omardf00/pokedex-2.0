package com.pokemon.pokedex.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import es.pokemon.pokedex.utils.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager manager) throws Exception {
		return http
				.csrf().disable()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.build();
	}
	
	@Bean
	UserDetailsService userDetailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles()
				.build());
		
		return manager;
	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService())
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
