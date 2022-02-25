package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Document("users")
public class User {
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    @Id
    private final String id;

    private final String email;
    private final String firstName;
    private final String lastName;
    private final Address homeAddress;
    private final String title;
    private final String jobTitle;
    private final boolean nonLogin;
    private final String source;

    //TODO add READ Only property/relation for user seats,
    // when we fetch the users to have all user seats that belongs to them,
    // the same time we don't want to persist assign seats when we creation/updating an user
    // Hint: see spring data @ReadOnlyProperty annotation

    @ReadOnlyProperty
    @DocumentReference
    List<Seat> seats;

}
