package com.pokemon.pokedex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="type")
@Data
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	
	@NotNull
	private String type;

}
