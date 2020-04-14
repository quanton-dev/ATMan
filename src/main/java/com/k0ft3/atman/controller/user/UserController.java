package com.k0ft3.atman.controller.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.k0ft3.atman.model.User;
import com.k0ft3.atman.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("user")
@Data
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<URI> addUser(@RequestBody User user) {
        User savedUser = userRepository.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@RequestParam String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();

    }

}