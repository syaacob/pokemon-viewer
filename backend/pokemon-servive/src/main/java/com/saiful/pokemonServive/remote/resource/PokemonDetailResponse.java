/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonDetailResponse {
    private int id;
    private String name;
    private Sprites sprites;

    @JsonProperty("base_experience")
    private int baseExperience;

    private List<Abilities> abilities;

    private List<Stats> stats;

    public  List<Types> types;

}
