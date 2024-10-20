package org.jsp.cda.controller;


import org.jsp.cda.entity.Faculty;

import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

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