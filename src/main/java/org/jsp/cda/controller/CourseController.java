package org.jsp.cda.controller;

import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repository.CourseRepository;
import org.jsp.cda.repository.FacultyRepository;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FacultyRepository facultyRepository;


    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable int id)
    {
        return courseService.findCourseById(id);
    }
    @GetMapping
    public ResponseEntity<?> findAllCourses()
    {
        return courseService.findAllCourses();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCourseById(@PathVariable int id, @RequestBody Course course)
    {
        return courseService.updateCourseById(id,course);
    }

    @PatchMapping(value = "/faculty/{cid}/{fid}")
    public ResponseEntity<?> setFacultyToCourse(@PathVariable int cid, @PathVariable int fid)
    {
        return courseService.setFacultyToCourse(cid,fid);
    }

    @PatchMapping(value = "/department/{cid}/{did}")
    public ResponseEntity<?> setDepartmentToCourse(@PathVariable int cid, @PathVariable int did){
        return courseService.setDepartmentToCourse(cid,did);
    }

}
