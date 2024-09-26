/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonList {
    private int count;
    private String next;
    private String previous;
    private List<PokemonDetail> results;
}
