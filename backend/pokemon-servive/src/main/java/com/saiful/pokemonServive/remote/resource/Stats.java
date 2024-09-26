/**
Author: Saiful Yaacob
*/
package com.saiful.pokemonServive.remote.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stats {
    @JsonProperty("base_stat")
    private int baseStat;
    private int effort;
    private Stat stat;
}
