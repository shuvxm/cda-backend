package org.jsp.cda.controller;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.entity.User;
import org.jsp.cda.repository.DepartmentRepository;
import org.jsp.cda.repository.FacultyRepository;
import org.jsp.cda.service.DepartmentService;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping(value = "/{uid}")
    public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty, @PathVariable int uid) {
        return facultyService.saveFaculty(faculty, uid);
    }

    @PatchMapping(value = "/department/{fid}/{did}")
    public ResponseEntity<?> setDepartmentToFaculty(
            @PathVariable int fid,
            @PathVariable int did)
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