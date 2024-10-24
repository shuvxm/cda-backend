package org.jsp.cda.controller;

import org.jsp.cda.entity.Student;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
//    http://localhost:8080/swagger-ui/index.html
    @Operation(summary = "To Create the Student through user id", description = "This API will accept the request body of Student Entity and accept the user id to ")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "All"),
    			@ApiResponse(responseCode = "200", description = "All")} )
    @PostMapping("/{uid}")
    public ResponseEntity<?> saveStudent(@PathVariable int uid, Student student)
    {
        return studentService.saveStudent(uid,student);
    }

    @PostMapping(value = "/upload/{sid}")
    public ResponseEntity<?> uploadPhoto(@PathVariable int sid, @RequestParam MultipartFile file){
        return studentService.uploadPhoto(sid,file);
    }

    @GetMapping
    public ResponseEntity<?> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }

    @PatchMapping(value = "/department/{sid}/{did}")
    public ResponseEntity<?> setDepartmentToStudent(@PathVariable int sid, @PathVariable int did){
        return studentService.setDepartmentToStudent(sid,did);
    }

    //


}
