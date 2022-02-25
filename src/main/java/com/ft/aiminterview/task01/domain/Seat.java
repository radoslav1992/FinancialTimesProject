package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ft.aiminterview.task01.config.ObjectIdDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@Document("seats")
public class Seat {
    @Id
    @JsonIgnore
    private ObjectId id;

    @JsonIgnore
    @Setter
    private ObjectId accessLicenceId;

    @JsonProperty
    //TODO What could be done to avoid this redundant serialization and deserialization config?
    // Could we just remove it?
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ObjectIdDeserializer.class)
    private ObjectId userId;

    @JsonProperty
    private LocalDateTime joinedDate;

    @JsonProperty
    private LocalDateTime seatExpiryDate;

}
