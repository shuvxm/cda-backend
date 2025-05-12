package org.jsp.cda.service;

import org.jsp.cda.entity.Administrator;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<?> saveAdmin(Administrator administrator);
}
