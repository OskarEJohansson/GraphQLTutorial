package com.tutorial.graphql.model;


import org.springframework.data.annotation.Id;
import org.springframework.graphql.data.federation.EntityMapping;

@EntityMapping
public record Country(    @Id
                          Integer id,
                          String name,
                          String emoji,
                          String currency,
                          String code,
                          String capital) {
}
