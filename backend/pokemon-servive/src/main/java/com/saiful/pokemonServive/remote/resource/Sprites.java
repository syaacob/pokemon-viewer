/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sprites {
    @JsonProperty("front_shiny")
    private String frontShiny;

    private OtherSprite other;
}
