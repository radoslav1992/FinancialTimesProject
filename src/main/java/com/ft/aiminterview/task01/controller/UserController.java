package com.ft.aiminterview.task01.controller;

import com.ft.aiminterview.task01.dao.UserRepository;
import com.ft.aiminterview.task01.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    //TODO Add getById endpoint

    @GetMapping
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    //TODO What could be improved for this endpoint?
    @GetMapping("searchByEmail")
    public User searchByEmail(@RequestParam("email") String email) {
        return userRepository.findUserByEmail(email);
    }

    //TODO Add mappings/(hhtp endpoints) for user create/update/delete operations. Mind the appropriate HTTP request verbs and HTTP response statuses
    // email address is unique don't allow creation of user with one and the same email, it should return the appropriate http status code in this case

    //TODO It is very important when you create/update users to validate the country code, it should be in ISO3Letter format
    // and  valid country(existing) to achive that make a HTTP call to public webservice:  https://restcountries.com/v2/alpha/{ISO3Letters}
    // more documentation here: https://restcountries.com/#api-endpoints-v2-code

}
