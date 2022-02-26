package com.ft.aiminterview.task01.mapper;

import com.ft.aiminterview.task01.domain.User;
import com.ft.aiminterview.task01.dtos.UserRequestDto;
import com.ft.aiminterview.task01.dtos.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setHomeAddress(user.getHomeAddress());
        userResponseDto.setTitle(user.getTitle());
        userResponseDto.setJobTitle(user.getJobTitle());
        userResponseDto.setNonLogin(user.isNonLogin());
        userResponseDto.setSource(user.getSource());
        userResponseDto.setSeats(user.getSeats());

        return userResponseDto;
    }

    public static List<UserResponseDto> userListToUserResponseDtoList(List<User> users) {
        return users.stream().map(user -> userToUserResponseDto(user)).collect(Collectors.toList());
    }

    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setHomeAddress(userRequestDto.getHomeAddress());
        user.setTitle(userRequestDto.getTitle());
        user.setJobTitle(userRequestDto.getJobTitle());
        user.setNonLogin(userRequestDto.isNonLogin());
        user.setSource(userRequestDto.getSource());

        return user;
    }
}
