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
@Table(name="tm")
@Data
public class TM {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTM;
	
	@JoinColumn(name="id_movement")
	@OneToOne
	private Movement movement;
	
	@NotNull
	private String name;

}
