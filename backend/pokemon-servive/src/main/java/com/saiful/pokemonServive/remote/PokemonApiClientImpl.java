/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote;

import com.saiful.pokemonServive.exception.PokemonApiException;
import com.saiful.pokemonServive.remote.resource.PokemonDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class PokemonApiClientImpl implements PokemonApiClient {
    private final RestClient restClient;

    public PokemonApiClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public PokemonApiResponse getPokemons(int offset, int limit) {
        PokemonApiResponse response = restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/pokemon").queryParam("offset", offset).queryParam("limit", limit)
                                .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, resp) -> {
                    throw new PokemonApiException("failed to call pokemon list api",  resp.getStatusCode());
                })
                .body(PokemonApiResponse.class);
        return response;
    }

    @Override
    public PokemonDetailResponse getPokemon(String id) {
        PokemonDetailResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/pokemon/{id}")
                        .build(id))
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, resp) -> {
                    log.error("failed to call pokemon by id api {}", resp.getStatusCode().value());
                    throw new PokemonApiException("failed to call pokemon by id api ",  resp.getStatusCode());
                })
                .body(PokemonDetailResponse.class);
        return response;
    }

}
