package com.ft.aiminterview.task01.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum LicenceStatus {
    ACTIVE,
    REVOKED,
    SUSPENDED;

}
