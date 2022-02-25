package com.ft.aiminterview.task01.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ft.aiminterview.task01.domain.LicenceStatus;
import com.ft.aiminterview.task01.domain.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class LicenseRequestDto {

    Set<Product>products;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime revocationDateTime;
    LicenceStatus status;
    Integer seatLimit;
    boolean ipAccessEnabled;
    Set<String> ipAccessAddresses;

}
