/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.service;

import com.saiful.pokemonServive.domain.PokemonDetail;
import com.saiful.pokemonServive.domain.PokemonList;

public interface PokemonService {
    PokemonList list(int offset, int limit);

    PokemonDetail get(String id);
}
