package com.pokemon.pokedex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="pokemon_detail")
@Data
public class PokemonDetail {

    @Id
    @OneToOne
    @JoinColumn(name = "num_pokedex")
    private Pokemon pokemon;

    private String category;

    private double weight;

    private double height;

    private String eggGroup;

    private double male;

    private double female;

    private String habitat;

    private String colour;

    private String generation;

    private String figure; //URL

    private String fingerprint; //URL

    private String scream; //URL

}
