package com.saiful.pokemonServive.service;

import com.saiful.pokemonServive.AbstractIntegrationTest;
import com.saiful.pokemonServive.domain.PokemonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PokemonServiceTest extends AbstractIntegrationTest {

    @Autowired
    private PokemonService pokemonService;

    @BeforeEach
    void setup() {
        mockServerClient.reset();
    }

    @Test
    void testListPokemonShouldSuccess() {

        String jsonList = "{\"count\": 10, \"results\" : [{\"id\": 1, \"url\" : \"http://saiful.test/1\"}]}";


        mockServerClient.when(HttpRequest.request().withMethod("GET").withPath("/pokemon"))
                .respond(HttpResponse.response().withContentType(MediaType.APPLICATION_JSON).withBody(jsonList).withStatusCode(200));

        mockServerClient.when(HttpRequest.request().withMethod("GET").withPath("/pokemon/1"))
                .respond(HttpResponse.response().withContentType(MediaType.APPLICATION_JSON).withBody(jsonPokemon()).withStatusCode(200));

        PokemonList list = pokemonService.list(0, 1);
        assertEquals(1, list.getResults().size());

    }

    String jsonPokemon(){
        return """
                {
                     "base_experience": 64,
                      "abilities": [
                             {
                                 "ability": {
                                     "name": "overgrow",
                                     "url": "https://pokeapi.co/api/v2/ability/65/"
                                 },
                                 "is_hidden": false,
                                 "slot": 1
                             }
                      ],
                      "sprites": {
                           "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png",
                            "other": {
                                "official-artwork": {
                                            "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                                            "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/1.png"
                                 }
                            }
                      },
                      "stats": [
                              {
                                  "base_stat": 45,
                                  "effort": 0,
                                  "stat": {
                                      "name": "hp",
                                      "url": "https://pokeapi.co/api/v2/stat/1/"
                                  }
                              }
                      ],
                       "types": [
                              {
                                  "slot": 1,
                                  "type": {
                                      "name": "grass",
                                      "url": "https://pokeapi.co/api/v2/type/12/"
                                  }
                              }
                       ]
                
                }
                """;
    }

}