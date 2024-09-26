/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote;

import com.saiful.pokemonServive.remote.resource.PokemonDetailResponse;

public interface PokemonApiClient {
    PokemonApiResponse getPokemons(int offset, int limit);
    PokemonDetailResponse getPokemon(String id);
}
