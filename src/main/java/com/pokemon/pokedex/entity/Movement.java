package com.pokemon.pokedex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="movement")
@Data
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovement;
	
	@NotNull
	private String name;
	
	@NotNull
	private int power;
	
	@NotNull
	private int precision;
	
	private String description;
	
	@NotNull
	private int pp;
	
	@NotNull
	private boolean priority;
	
	@JoinColumn(name="id_type")
	@ManyToOne
	private Type type;

}
