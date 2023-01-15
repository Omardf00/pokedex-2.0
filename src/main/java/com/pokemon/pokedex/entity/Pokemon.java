package com.pokemon.pokedex.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="pokemon")
@Data
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numPokedex;
	
	@NotNull
	private String name;
	
	private double weight;
	
	private double height;
	
	@ManyToMany
	@JoinTable(
			name = "pokemon_type",
			joinColumns = @JoinColumn(name = "num_pokedex", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "id_type", nullable = false)
	)
	private List<Type> type;

}
