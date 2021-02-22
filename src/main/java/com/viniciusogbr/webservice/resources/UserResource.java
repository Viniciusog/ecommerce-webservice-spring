package com.viniciusogbr.webservice.resources;

import com.viniciusogbr.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Henrique", "henrique@gmail.com",
                "69995874596", "senha");
        return ResponseEntity.ok().body(u);
    }
}
