package com.seekho.seekho.controller;

import com.seekho.seekho.model.Coupon;
import com.seekho.seekho.model.User;
import com.seekho.seekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        return ResponseEntity.ok(this.userService.addUser(user));
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers()
    {
        return ResponseEntity.ok(this.userService.getUsers());
    }

}
