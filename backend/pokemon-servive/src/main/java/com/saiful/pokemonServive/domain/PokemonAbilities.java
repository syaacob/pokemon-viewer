/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAbilities {
    private int slot;
    private boolean hidden;
    private PokemonAbility ability;
}
