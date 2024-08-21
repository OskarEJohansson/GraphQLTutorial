package com.tutorial.graphql.service;

import com.tutorial.graphql.model.Country;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CountryService {

    public Mono<List<Country>> getCountries();
}
