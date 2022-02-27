package com.ft.aiminterview.task01.service;

import com.ft.aiminterview.task01.dao.UserRepository;
import com.ft.aiminterview.task01.domain.User;
import com.ft.aiminterview.task01.dtos.UserRequestDto;
import com.ft.aiminterview.task01.dtos.UserResponseDto;
import com.ft.aiminterview.task01.exceptions.EntityAlreadyExistsException;
import com.ft.aiminterview.task01.exceptions.EntityNotFoundException;
import com.ft.aiminterview.task01.exceptions.IncorrectCountryCodeException;
import com.ft.aiminterview.task01.mapper.UserMapper;
import com.ft.aiminterview.task01.utils.UserUtils;
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

        if (userRepository.findByEmail(userRequestDto.getEmail()) != null) {
            throw new EntityAlreadyExistsException();
        } else if(!UserUtils.validateCountryCode(userRequestDto.getHomeAddress().getCountry())) {
            throw new IncorrectCountryCodeException();
        }

        return UserMapper.userToUserResponseDto(userRepository.save(user));
    }

    public UserResponseDto update(UserRequestDto userRequestDto, String id) {

        if (UserUtils.validateCountryCode(userRequestDto.getHomeAddress().getCountry())) {
            throw new IncorrectCountryCodeException();
        }

        User user = userRepository.findById(id).map(userToUpdate -> {
                    userToUpdate.setEmail(userRequestDto.getEmail());
                    userToUpdate.setFirstName(userRequestDto.getFirstName());
                    userToUpdate.setLastName(userRequestDto.getLastName());
                    userToUpdate.setHomeAddress(userRequestDto.getHomeAddress());
                    userToUpdate.setTitle(userRequestDto.getTitle());
                    userToUpdate.setJobTitle(userRequestDto.getJobTitle());
                    userToUpdate.setNonLogin(userRequestDto.isNonLogin());
                    userToUpdate.setSource(userRequestDto.getSource());
                    return userToUpdate;
                })
                .orElseThrow(EntityNotFoundException::new);

        return UserMapper.userToUserResponseDto(userRepository.save(user));
    }

    public void delete(String id) {
        User userToDelete = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(userToDelete);
    }
}
