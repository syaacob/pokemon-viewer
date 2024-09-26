/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.service;

import com.saiful.pokemonServive.domain.*;
import com.saiful.pokemonServive.remote.*;
import com.saiful.pokemonServive.remote.resource.*;
import com.saiful.pokemonServive.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private final PokemonApiClient pokemonApiClient;

    public PokemonServiceImpl(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    @Override
    public PokemonList list(int offset, int limit) {
        log.info("requesting offset {}", offset);
        PokemonApiResponse pokemons = pokemonApiClient.getPokemons(offset, limit);
        log.info("total pokemons {}", pokemons.getCount());

        PokemonList pokemonList = new PokemonList();
        pokemonList.setCount(pokemons.getCount());
        pokemonList.setNext(pokemons.getNext());
        pokemonList.setPrevious(pokemons.getPrevious());
        pokemonList.setResults(getPokemonDetails(pokemons.getResults()));
        return pokemonList;
    }

    @Override
    public PokemonDetail get(String id) {
        PokemonDetailResponse pokemon = pokemonApiClient.getPokemon(id);
        return convertPokemonDetailResponse(pokemon);
    }

    private List<PokemonDetail> getPokemonDetails(List<PokemonResult> pokemonResult){
        List<PokemonDetail> results = new ArrayList<>();
        for (PokemonResult result: pokemonResult){
            String id = Util.getLastPathSegment(result.getUrl());
            PokemonDetailResponse pokemon = pokemonApiClient.getPokemon(id);
            results.add(convertPokemonDetailResponse(pokemon));
        }
        return results;
    }

    private PokemonDetail convertPokemonDetailResponse(PokemonDetailResponse response){
        PokemonDetail detail = new PokemonDetail();
        detail.setName(response.getName());
        detail.setId(String.valueOf(response.getId()));
        detail.setBaseExperience(response.getBaseExperience());
        detail.setAvatar(response.getSprites().getFrontShiny());
        detail.setDefaultImage(response.getSprites().getOther().getOfficialArtwork().getFrontDefault());
        detail.setAbilities(response.getAbilities().stream().map(this::convertAbilities).collect(Collectors.toList()));
        detail.setStats(response.getStats().stream().map(this::convertStats).collect(Collectors.toList()));
        detail.setTypes(response.getTypes().stream().map(this::convertTypes).collect(Collectors.toList()));
        return detail;

    }

    private PokemonTypes convertTypes(Types x) {
        PokemonTypes pokemonTypes = new PokemonTypes();
        pokemonTypes.setSlot(x.getSlot());

        PokemonType pokemonType = new PokemonType();
        pokemonType.setId(Util.getLastPathSegment(x.getType().getUrl()));
        pokemonType.setName(x.getType().getName());

        pokemonTypes.setType(pokemonType);

        return pokemonTypes;
    }

    private PokemonStats convertStats(Stats stats) {
        PokemonStats pokemonStats = new PokemonStats();
        pokemonStats.setBaseStat(stats.getBaseStat());
        pokemonStats.setEffort(stats.getEffort());

        PokemonStat pokemonStat = new PokemonStat();
        pokemonStat.setId(Util.getLastPathSegment(stats.getStat().getUrl()));
        pokemonStat.setName(stats.getStat().getName());
        pokemonStats.setStat(pokemonStat);

        return pokemonStats;
    }

    private PokemonAbilities convertAbilities(Abilities abilities){
        PokemonAbilities pokemonAbilities = new PokemonAbilities();
        pokemonAbilities.setSlot(abilities.getSlot());
        pokemonAbilities.setHidden(abilities.isHidden());

        PokemonAbility pokemonAbility = new PokemonAbility();
        pokemonAbility.setId( Util.getLastPathSegment(abilities.getAbility().getUrl()));
        pokemonAbility.setName(abilities.getAbility().getName());
        pokemonAbilities.setAbility(pokemonAbility);
        return pokemonAbilities;
    }

}
