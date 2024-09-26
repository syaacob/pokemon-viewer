/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonDetail {
    private String id;
    private String name;
    private String avatar;
    private int baseExperience;

    private String defaultImage;

    private List<PokemonAbilities> abilities;

    private List<PokemonTypes> types;

    private List<PokemonStats> stats;
}
