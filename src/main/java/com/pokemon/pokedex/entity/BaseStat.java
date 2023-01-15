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
@Table(name="base_stat")
@Data
public class BaseStat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBaseStat;
	
	@OneToOne
	@JoinColumn(name="num_pokedex")
	private Pokemon pokemon;
	
	@NotNull
	private int ps;
	
	@NotNull
	private int attack;
	
	@NotNull
	private int specialAttack;
	
	@NotNull
	private int defence;
	
	@NotNull
	private int specialDefence;
	
	@NotNull
	private int velocity;

}
