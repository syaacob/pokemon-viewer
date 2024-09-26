package com.saiful.pokemonServive;

import com.saiful.pokemonServive.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void testGetLastPathSegment() {
        String lastPathSegment = Util.getLastPathSegment("https://pokeapi.co/api/v2/pokemon/8/");
        assertEquals("8", lastPathSegment);
    }
}