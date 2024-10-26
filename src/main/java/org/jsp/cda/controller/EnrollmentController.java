package org.jsp.cda.controller;

import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;


    @PostMapping("/{cid}/{sid}")
    public ResponseEntity<?> saveEnrollment(@PathVariable int cid, @PathVariable int sid){
        return enrollmentService.saveEnrollment(cid,sid);
    }

    @GetMapping(value = "/student/{sid}")
    public ResponseEntity<?> findEnrollmentByStudentId(@PathVariable int sid){
        return enrollmentService.findEnrollmentByStudentId(sid);
    }

    @GetMapping(value = "/course/{cid}")
    public ResponseEntity<?> findEnrollmentByCourseId(@PathVariable int cid){
        return enrollmentService.findEnrollmentByCourseId(cid);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findEnrollmentById(@PathVariable int id){
        return enrollmentService.findEnrollmentById(id);
    }

    @GetMapping
    public ResponseEntity<?> findAllEnrollments(){
        return enrollmentService.findAllEnrollments();
    }


}
