package com.ft.aiminterview.task01.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ft.aiminterview.task01.domain.LicenceStatus;
import com.ft.aiminterview.task01.domain.Product;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class LicenseResponseDto {

    @JsonProperty("id")
    ObjectId accessLicenceId;
    LocalDateTime creationDateTime;
    Set<Product> products;
    LocalDateTime revocationDateTime;
    LicenceStatus status;
    Integer seatLimit;
    boolean ipAccessEnabled;
    Set<String> ipAccessAddresses;
    LocalDateTime lastUpdatedDateTime;

}
