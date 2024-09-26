/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Abilities {
    @JsonProperty("is_hidden")
    private boolean isHidden;
    private int slot;
    private Ability ability;
}
