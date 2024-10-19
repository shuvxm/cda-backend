package org.jsp.cda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController {

    @PostMapping("/{cid}/{sid}")
    public ResponseEntity<?> saveEnrollment(@PathVariable int cid, @PathVariable int sid){
        return null;
    }


}
