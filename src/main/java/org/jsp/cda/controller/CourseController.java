package org.jsp.cda.controller;

import org.jsp.cda.entity.Course;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

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
}
