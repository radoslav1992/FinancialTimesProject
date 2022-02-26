package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@RequiredArgsConstructor
@Document("users")
public class User {
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    @Id
    private String id;

    private String email;
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private String title;
    private String jobTitle;
    private boolean nonLogin;
    private String source;

    //TODO add READ Only property/relation for user seats,
    // when we fetch the users to have all user seats that belongs to them,
    // the same time we don't want to persist assign seats when we creation/updating an user
    // Hint: see spring data @ReadOnlyProperty annotation

    @ReadOnlyProperty
    @DocumentReference
    List<Seat> seats;

}
