/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.controller;

import com.saiful.pokemonServive.exception.PokemonApiException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    ProblemDetail noSuchRecordException(PokemonApiException pae){
        ProblemDetail problemDetail = ProblemDetail.forStatus(pae.getHttpStatus().value());
        problemDetail.setDetail(pae.getMessage());
        return problemDetail;
    }
}
