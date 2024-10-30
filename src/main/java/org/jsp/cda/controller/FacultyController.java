package org.jsp.cda.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jsp.cda.entity.Faculty;

import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@CrossOrigin
@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Operation(summary = "To Create the Faculty through user id", description = "This API will accept the request body of Faculty Entity and accept the user id to map ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Faculty created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    } )
    @PostMapping(value = "/{uid}")
    public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty, @PathVariable int uid) {
        return facultyService.saveFaculty(faculty, uid);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findFacultyById(@PathVariable int id){
        return facultyService.findFacultyById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAllFaculties(){
        return facultyService.findAllFaculties();
    }

    @PatchMapping(value = "/department/{fid}/{did}")
    public ResponseEntity<?> setDepartmentToFaculty(
            @PathVariable(name = "fid") int fid,
            @PathVariable(name = "did") int did)
    {
        return facultyService.assignDepartmentToFaculty(fid, did);
    }

    @PatchMapping("/officeHours/{fid}")
    public ResponseEntity<?> setOfficeHours(@PathVariable int fid, @RequestParam LocalTime officeHours){
        return facultyService.setOfficeHours(fid, officeHours);
    }
}


//    @PatchMapping(value = "/{fid}/{did}")
//    public ResponseEntity<?> setDepartmentToFaculty(@PathVariable int fid, @PathVariable int did, int uid){
////        Optional<Faculty> optional1 = facultyService.findFacultyById(fid);
////        Optional<Department> optional2 =  departmentService.findDepartmentById(did);
//////        do validation here
//////
//////        if(optional1.isEmpty())
//////            throw new RuntimeException();
////
////        Faculty faculty = optional1.get();
////        Department department = optional2.get();
////
////        faculty.setDepartment(department);
//        return facultyService.saveFaculty(faculty,uid);
////        return null;
//    }