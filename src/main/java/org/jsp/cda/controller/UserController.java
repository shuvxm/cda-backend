package org.jsp.cda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "User Login",
            description = "This API allows a user to log in by providing authentication credentials.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "400", description = "Invalid authentication credentials")
    } )
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthUser authUser){
        return userService.login(authUser);
    }


    @Operation(summary = "Create a new user",
            description = "This API allows for the creation of a new user by accepting a User entity in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
//            @ApiResponse(responseCode = "409", description = "User already exists"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @Operation(summary = "To find all the users", description = "This API will fetched all the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all users successfully"),
            @ApiResponse(responseCode = "400", description = "No user found")
    } )
    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        return userService.findAllUsers();
    }

    @Operation(summary = "To find User through their id", description = "This API will fetched users by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched user successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }


    @Operation(summary = "To update Role to the student", description = "This API will fetched users by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched user successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @PutMapping(value = "/{id}/student")
    public ResponseEntity<?> updateRoleToStudent(@PathVariable int id) {
    	return userService.updateRoleToStudent(id);
    }

    @PostMapping("/user/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody AuthOTP authOTP){
        return userService.verifyOTP(authOTP);
    }

}

