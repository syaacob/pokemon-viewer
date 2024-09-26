/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.remote.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtherSprite {
    @JsonProperty("official-artwork")
    private OfficialArtwork officialArtwork;
}
