package com.ft.aiminterview.task01.service;

import com.ft.aiminterview.task01.dao.UserRepository;
import com.ft.aiminterview.task01.domain.User;
import com.ft.aiminterview.task01.dtos.UserRequestDto;
import com.ft.aiminterview.task01.dtos.UserResponseDto;
import com.ft.aiminterview.task01.exceptions.EntityNotFoundException;
import com.ft.aiminterview.task01.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return UserMapper.userToUserResponseDto(user);
    }

    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();

        return UserMapper.userListToUserResponseDtoList(users);
    }

    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new EntityNotFoundException();
        } else {
            return UserMapper.userToUserResponseDto(user);
        }
    }

    public UserResponseDto create(UserRequestDto userRequestDto) {
        User user = UserMapper.userRequestDtoToUser(userRequestDto);

        return UserMapper.userToUserResponseDto(userRepository.save(user));
    }
}
