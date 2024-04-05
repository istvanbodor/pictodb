package com.example.picturedemo.services;

import com.example.picturedemo.model.User;
import com.example.picturedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<User> createNewUser(String name, MultipartFile file) throws IOException {
        User user = User.
            builder().
            userName(name)
            .displayPicture(file.getBytes())
            .build();
        repository.save(user);
        user.setDisplayPicture(null);
        return ResponseEntity.ok(user);
    }
}