/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeanConfig {

    @Bean
    public RestClient restClient(@Value("${api.path}") String apiUrl){
        RestClient restClient = RestClient.builder()
                .baseUrl(apiUrl)
                .build();

        return restClient;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
