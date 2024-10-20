package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

    ResponseEntity<?> saveEnrollment(int cid, int sid);
}
