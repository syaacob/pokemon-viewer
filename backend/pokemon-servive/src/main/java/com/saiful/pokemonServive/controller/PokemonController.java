/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.controller;

import com.saiful.pokemonServive.domain.PokemonDetail;
import com.saiful.pokemonServive.domain.PokemonList;
import com.saiful.pokemonServive.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<PokemonList> list(@RequestParam int offset, @RequestParam int limit) {
        return ResponseEntity.ok(pokemonService.list(offset, limit));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PokemonDetail> get(@PathVariable String id){
        return ResponseEntity.ok(pokemonService.get(id));
    }
}
