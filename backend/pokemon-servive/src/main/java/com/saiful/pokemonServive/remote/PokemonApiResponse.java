/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote;

import com.saiful.pokemonServive.remote.resource.PokemonResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonApiResponse {
    private int count;
    private String next;
    private String previous;
    private List<PokemonResult> results;
}
