package com.ft.aiminterview.task01.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserUtils {

    public static boolean validateCountryCode(String country) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity("https://restcountries.com/v2/alpha/" + country, String.class);

        return response.getStatusCodeValue() == 200 ? true : false;
    }

}
