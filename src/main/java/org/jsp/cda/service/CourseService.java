package org.jsp.cda.service;

import org.jsp.cda.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {
    
    ResponseEntity<?> saveCourse(Course course);

    ResponseEntity<?> findCourseById(int id);

    ResponseEntity<?> findAllCourses();

    ResponseEntity<?> updateCourseById(int id, Course course);

    ResponseEntity<?> setFacultyToCourse(int cid, int fid);

    ResponseEntity<?> setDepartmentToCourse(int cid, int did);
}
