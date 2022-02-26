package com.ft.aiminterview.task01.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ft.aiminterview.task01.domain.LicenceStatus;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class LicensePatchStatusDto {

    @JsonProperty("id")
    ObjectId accessLicenceId;
    LicenceStatus status;

}
