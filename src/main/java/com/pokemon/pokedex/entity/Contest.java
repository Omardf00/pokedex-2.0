package com.pokemon.pokedex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="contest")
@Data
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContest;

    @NotNull
    private String name;
}
