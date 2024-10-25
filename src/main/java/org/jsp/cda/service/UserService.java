package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.utility.AuthOTP;
import org.jsp.cda.utility.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUser(User user);
    ResponseEntity<?> findAllUsers();
    ResponseEntity<?> findUserById(int id);
	ResponseEntity<?> updateRoleToStudent(int id);

    ResponseEntity<?> login(AuthUser authUser);

    ResponseEntity<?> verifyOTP(AuthOTP authOTP);
}


