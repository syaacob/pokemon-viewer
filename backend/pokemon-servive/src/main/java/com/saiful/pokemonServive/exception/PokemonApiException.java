/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class PokemonApiException extends RuntimeException {
    private final HttpStatus httpStatus;
    public PokemonApiException(String message, HttpStatusCode httpStatus){
        super(message);
        this.httpStatus = HttpStatus.valueOf(httpStatus.value());
    }
}
