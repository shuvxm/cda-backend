package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.repository.UserRepository;
import org.jsp.cda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your frontend
public class AuthController {

    // Injecting the UserService to handle the business logic
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            // Check if the email is already registered

            if (userRepository.existsByEmail(user.getEmail())) {
                // If the email already exists, return a bad request with a specific message
                return new ResponseEntity<>("Email already registered", HttpStatus.BAD_REQUEST);
            }

            // Call the UserService to register the user
            User registeredUser = userService.registerUser(user);

            // Return a success response with the registered user data
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle any unexpected errors during registration
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
