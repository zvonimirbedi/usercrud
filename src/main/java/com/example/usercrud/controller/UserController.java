package com.example.usercrud.controller;

import com.example.usercrud.dto.UserDto;
import com.example.usercrud.model.User;
import com.example.usercrud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@Api(tags = "ControllerCustomer", description = "Rest users APIs")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The request has succeeded"),
        @ApiResponse(code = 401, message = "The request requires user authentication"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI")})
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> creatUser(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.creatUser(user), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable int id){
        if (userService.deleteUser(id))
            return new ResponseEntity<>(null, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    private ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
