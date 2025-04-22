package org.jsp.cda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jsp.cda.entity.Administrator;
import org.jsp.cda.service.AdminService;
import org.jsp.cda.service.FacultyService;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentService studentService;

    @Operation(summary = "To Create the admin", description = "This API will accept the request body of Admin Entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<?> saveAdmin(@RequestBody Administrator administrator) {
        return adminService.saveAdmin(administrator);
    }

    @Operation(summary = "Get all faculty members", description = "This API returns all faculty members")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved faculty list"),
            @ApiResponse(responseCode = "404", description = "No faculty found")
    })
    @GetMapping("/faculty")
    public ResponseEntity<?> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @Operation(summary = "Get all students", description = "This API returns all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved students list"),
            @ApiResponse(responseCode = "404", description = "No students found")
    })
    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        return studentService.getAllStudents();
    }
}







//
//@CrossOrigin
//@RestController
//@RequestMapping(value = "/admins")
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//
//    @Operation(summary = "To Create the admin ", description = "This API will accept the request body of Admin Entity ")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Admin created successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid input data")
//    })
//    @PostMapping
//    public ResponseEntity<?> saveAdmin(@RequestBody Administrator administrator){
//        return adminService.saveAdmin(administrator);
//    }
//
//}
