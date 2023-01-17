package com.pokemon.pokedex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="evolution_level")
@Data
public class EvolutionLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvolutionLevel;
	
	@OneToOne
	@JoinColumn(name="num_pokedex")
	private Pokemon pokemon;
	
	@NotNull
	private int level;

}
