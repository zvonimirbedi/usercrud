package com.example.usercrud.service;

import com.example.usercrud.component.Validation;
import com.example.usercrud.dto.UserDto;
import com.example.usercrud.model.User;
import com.example.usercrud.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Validation validation;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Optional<User> getUserById(int id) {
        log.info("Getting user: " + id);
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<?> creatUser(UserDto userDto) {
        log.info("Creating user: " + userDto);
        List<String> errors = validation.userDtoValidation(userDto);
        if(errors.size()>0)
            return Optional.of(errors);
        User user = modelMapper.map(userDto, User.class);
        return Optional.of(userRepository.save(user));
    }

    @Transactional
    public Optional<?> updateUser(User user) {
        log.info("Updating user: " + user);
        List<String> errors = validation.userValidation(user);
        if(errors.size()>0)
            return Optional.of(errors);
        return Optional.of(userRepository.save(user));
    }

    @Transactional
    public boolean deleteUser(int id) {
        log.info("Deleting user: " + id);
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else
            return false;
    }
    @Transactional
    public Collection<User> getAllUsers() {
        log.info("Getting all users");
        return userRepository.getAll();
    }
}
