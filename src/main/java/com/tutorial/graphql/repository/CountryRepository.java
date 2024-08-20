package com.tutorial.graphql.repository;

import com.tutorial.graphql.model.Country;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ListCrudRepository<Country, Integer> {
}
