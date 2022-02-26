package com.ft.aiminterview.task01.dtos;

import com.ft.aiminterview.task01.domain.Address;
import lombok.Data;

@Data
public class UserRequestDto {

    private String email;
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private String title;
    private String jobTitle;
    private boolean nonLogin;
    private String source;

}
