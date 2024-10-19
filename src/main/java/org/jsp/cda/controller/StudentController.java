package org.jsp.cda.controller;

import org.jsp.cda.entity.Student;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(Student student)
    {
        return studentService.saveStudent(student);
    }

    @PatchMapping(value = "/department/{sid}/{did}")
    public ResponseEntity<?> setDepartmentToStudent(@PathVariable int sid, @PathVariable int did){
        return studentService.setDepartmentToStudent(sid,did);
    }


}
