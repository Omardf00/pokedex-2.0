package com.pokemon.pokedex.entity;

import jakarta.persistence.*;
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

	private String secondaryEffect;

	@NotNull
	private int pp;
	
	@NotNull
	private int priority;

	@JoinColumn(name = "movement_category")
	@OneToOne
	private MovementCategory movementCategory;

	private String contest;

	@JoinColumn(name="id_type")
	@ManyToOne
	private Type type;

}
