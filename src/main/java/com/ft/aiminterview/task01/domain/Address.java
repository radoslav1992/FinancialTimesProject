package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private final String line1;
    private final String line2;
    private final String townCity;
    private final String state;
    private final String postcode;
    private final String country;

    @JsonCreator
    public Address(@JsonProperty("line1") String line1,
                   @JsonProperty("line2") String line2,
                   @JsonProperty("townCity") String townCity,
                   @JsonProperty("state") String state,
                   @JsonProperty("postcode") String postcode,
                   @JsonProperty("country") String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.townCity = townCity;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

}