/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonResult {
    private String name;
    private String url;
    private String baseExperience;
}
