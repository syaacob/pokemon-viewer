/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonStats {
    private int baseStat;
    private int effort;
    private PokemonStat stat;
}
