package com.example.picturedemo.controllers;


import com.example.picturedemo.model.User;
import com.example.picturedemo.repository.UserRepository;
import com.example.picturedemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping()
    public ResponseEntity<User> createNewUser(@RequestParam String name, @RequestPart("file") MultipartFile file) {
        try {
            return userService.createNewUser(name, file);
        } catch (IOException e) {
            return new ResponseEntity<User>(HttpStatusCode.valueOf(400));
        }

    }


}
