package com.tutorial.graphql;

import com.tutorial.graphql.model.Country;
import com.tutorial.graphql.repository.CountryRepository;
import com.tutorial.graphql.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository){
        return args -> {
           Mono<List<Country>> countries = service.getCountries();
           countries.subscribe(repository::saveAll);
        };
    }
}
