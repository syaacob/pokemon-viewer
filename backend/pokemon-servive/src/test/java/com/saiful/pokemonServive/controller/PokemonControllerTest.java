package com.saiful.pokemonServive.controller;

import com.saiful.pokemonServive.domain.PokemonDetail;
import com.saiful.pokemonServive.domain.PokemonList;
import com.saiful.pokemonServive.service.PokemonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(controllers = PokemonController.class)
class PokemonControllerTest {

    @BeforeEach
    void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void testListPokemons() {
        Mockito.when(pokemonService.list(0, 20)).thenReturn(getPokemonList());
        RestAssuredMockMvc.given()
                .param("offset",0)
                .param("limit", 20)
                .when()
                .get("/pokemons")
                .then()
                .status(HttpStatus.OK)
                .body("results", Matchers.hasSize(Matchers.greaterThan(0)) );
    }

    private PokemonList getPokemonList() {
        PokemonList list = new PokemonList();
        list.setNext("N");
        list.setPrevious("P");
        list.setResults(List.of(new PokemonDetail()));
        return list;
    }

    @Test
    void testGePokemonDetail() {
        RestAssuredMockMvc.given()
                .when()
                .get("/pokemons/1")
                .then()
                .status(HttpStatus.OK);
    }
  
}