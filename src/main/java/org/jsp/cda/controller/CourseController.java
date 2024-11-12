package org.jsp.cda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "To Create the Course ", description = "This API will accept the request body of course Entity ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody Course course)
    {
        return courseService.saveCourse(course);
    }
    @Operation(summary = "To Find the Course by their id ", description = "This API will find the Course by their id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable int id)
    {
        return courseService.findCourseById(id);
    }

    @Operation(summary = "To Find all the Course ", description = "This API will find all the Course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Courses fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @GetMapping
    public ResponseEntity<?> findAllCourses()
    {
        return courseService.findAllCourses();
    }

    @Operation(summary = "To update the Course by their id ", description = "This API will update the Course by their id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
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
