package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

import static java.util.Objects.requireNonNull;

@Value
@JsonSerialize
public class Product {

    @JsonProperty
    String code;
    @JsonProperty
    String name;

    @JsonCreator
    public Product(@JsonProperty("code") final String code, @JsonProperty("name") final String name) {
        this.name = name;
        this.code = requireNonNull(code, "product code cannot be null");
    }

}
