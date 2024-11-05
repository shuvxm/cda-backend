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

//http://localhost:8080/swagger-ui/index.html - documentation link


@CrossOrigin
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "To Create the Student through user id", description = "This API will accept the request body of Student Entity and accept the user id to ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @PostMapping("/{uid}")
    public ResponseEntity<?> saveStudent(@PathVariable int uid, Student student)
    {
        return studentService.saveStudent(uid,student);
    }

    @PostMapping(value = "/upload/{sid}")
    public ResponseEntity<?> uploadPhoto(@PathVariable int sid, @RequestParam MultipartFile file){
        return studentService.uploadPhoto(sid,file);
    }

    @Operation(summary = "To find all the students", description = "This API will fetched all the students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all student successfully"),
            @ApiResponse(responseCode = "400", description = "No student found")
    } )
    @GetMapping
    public ResponseEntity<?> findAllStudents(){
        return studentService.findAllStudents();
    }

    @Operation(summary = "To find Student through their id", description = "This API will fetched student by their id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched student successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }

    @Operation(summary = "To Assign department to the Student", description = "This API will assign the department to  student ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assigned department to student successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @PatchMapping(value = "/department/{sid}/{did}")
    public ResponseEntity<?> setDepartmentToStudent(@PathVariable int sid, @PathVariable int did){
        return studentService.setDepartmentToStudent(sid,did);
    }

    //


}
