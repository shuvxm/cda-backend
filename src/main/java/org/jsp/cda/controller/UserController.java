package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.utility.AuthOTP;
import org.jsp.cda.utility.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.jsp.cda.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthUser authUser){
        return userService.login(authUser);
    }


    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
    
    @PutMapping(value = "/{id}/student")
    public ResponseEntity<?> updateRoleToStudent(@PathVariable int id) {
    	return userService.updateRoleToStudent(id);
    }

    @PostMapping("/user/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody AuthOTP authOTP){
        return userService.verifyOTP(authOTP);
    }

}

