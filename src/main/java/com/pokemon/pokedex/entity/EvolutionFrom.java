package com.pokemon.pokedex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="evolution_from")
@Data
public class EvolutionFrom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvolution;
	
	@OneToOne
	@JoinColumn(name="num_pokedex_origin")
	private Pokemon originPokemon;
	
	@OneToOne
	@JoinColumn(name="num_pokedex_evolutioned")
	private Pokemon evolutionedPokemon;
	
	@OneToOne
	@JoinColumn(name="id_form")
	private EvolutionForm evolutionForm;

}
