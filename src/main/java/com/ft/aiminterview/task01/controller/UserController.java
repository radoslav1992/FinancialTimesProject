package com.ft.aiminterview.task01.controller;

import com.ft.aiminterview.task01.dao.UserRepository;
import com.ft.aiminterview.task01.domain.User;

import com.ft.aiminterview.task01.dtos.UserRequestDto;
import com.ft.aiminterview.task01.dtos.UserResponseDto;
import com.ft.aiminterview.task01.exceptions.EntityAlreadyExistsException;
import com.ft.aiminterview.task01.exceptions.EntityNotFoundException;
import com.ft.aiminterview.task01.service.LicenseService;
import com.ft.aiminterview.task01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    //TODO Add getById endpoint
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String id) {
        UserResponseDto userResponseDto;
        try {
            userResponseDto = userService.getUser(id);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<UserResponseDto>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    //TODO What could be improved for this endpoint?
    @GetMapping("/searchByEmail")
    public ResponseEntity<UserResponseDto> searchByEmail(@RequestParam("email") String email) {
        UserResponseDto userResponseDto;

        try {
            userResponseDto = userService.getUserByEmail(email);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<UserResponseDto>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(userResponseDto);
    }

    //TODO Add mappings/(hhtp endpoints) for user create/update/delete operations. Mind the appropriate HTTP request verbs and HTTP response statuses
    // email address is unique don't allow creation of user with one and the same email, it should return the appropriate http status code in this case
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto;

        try {
            userResponseDto = userService.create(userRequestDto);
        } catch(EntityAlreadyExistsException ex) {
            return new ResponseEntity<UserResponseDto>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok().body(userResponseDto);
    }

    //TODO It is very important when you create/update users to validate the country code, it should be in ISO3Letter format
    // and  valid country(existing) to achive that make a HTTP call to public webservice:  https://restcountries.com/v2/alpha/{ISO3Letters}
    // more documentation here: https://restcountries.com/#api-endpoints-v2-code

}
