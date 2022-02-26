package com.ft.aiminterview.task01.dtos;

import com.ft.aiminterview.task01.domain.Address;
import com.ft.aiminterview.task01.domain.Seat;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private String title;
    private String jobTitle;
    private boolean nonLogin;
    private String source;
    private List<Seat> seats;

}
