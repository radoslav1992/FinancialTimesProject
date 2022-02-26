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
    private ObjectId accessLicenceId;
    private LocalDateTime creationDateTime;
    private Set<Product> products;
    private LocalDateTime revocationDateTime;
    private LicenceStatus status;
    private Integer seatLimit;
    private boolean ipAccessEnabled;
    private Set<String> ipAccessAddresses;
    private LocalDateTime lastUpdatedDateTime;

}
