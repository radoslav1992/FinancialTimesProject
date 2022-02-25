package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@RequiredArgsConstructor
@Document("licences")
public class Licence {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    ObjectId accessLicenceId;

    @JsonProperty
    @CreatedDate
    LocalDateTime creationDateTime;

    @JsonProperty
    Set<Product> products;

    @JsonProperty
    LocalDateTime revocationDateTime;

    @JsonProperty
    LicenceStatus status;

    @JsonProperty
    Integer seatLimit;

    @JsonProperty
    boolean ipAccessEnabled;

    @JsonProperty
    Set<String> ipAccessAddresses;

    @JsonProperty
    @LastModifiedDate
    LocalDateTime lastUpdatedDateTime;

    @DocumentReference
    private List<Seat> seats;

    @JsonCreator
    public Licence(@JsonProperty("id") ObjectId accessLicenceId,
                   @JsonProperty("creationDateTime") LocalDateTime creationDateTime,
                   @JsonProperty("products") Set<Product> products,
                   @JsonProperty("revocationDateTime") LocalDateTime revocationDateTime,
                   @JsonProperty("status") LicenceStatus status,
                   @JsonProperty("seatLimit") Integer seatLimit,
                   @JsonProperty("ipAccessEnabled") Boolean ipAccessEnabled,
                   @JsonProperty("ipAccessAddresses") Set<String> ipAccessAddresses,
                   @JsonProperty("lastUpdatedDateTime") LocalDateTime lastUpdatedDateTime){
        this.accessLicenceId = requireNonNull(accessLicenceId, "accessLicenceId cannot be null");
        this.creationDateTime = requireNonNull(creationDateTime, "creationDateTime cannot be null");
        requireNonNull(products, "products cannot be null");
        if (products.isEmpty()) {
            throw new IllegalArgumentException("Must have at least one products");
        }
        this.products = Set.copyOf(products);
        this.revocationDateTime = revocationDateTime;
        this.status = requireNonNull(status, "status cannot be null");
        this.seatLimit = seatLimit != null ? seatLimit : 0;
        this.ipAccessEnabled = ipAccessEnabled != null ? ipAccessEnabled : false;
        this.ipAccessAddresses = ipAccessAddresses;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    @JsonProperty
    public Set<Product> getProducts() {
        return (null == this.products) ? Collections.emptySet() : Set.copyOf(this.products);
    }

    @JsonIgnore
    public boolean hasCapacity() {
        return seatLimit == null || seats.size() < seatLimit;
    }


}
