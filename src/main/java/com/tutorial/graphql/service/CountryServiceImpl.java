package com.tutorial.graphql.service;

import com.tutorial.graphql.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryServiceImpl() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }


    public Mono<List<Country>> getCountries() {
        String document = """
                query {
                    countries {
                    name
                    emoji
                    currency
                    code
                    capital
                  }
                }
                """;

        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }

}
