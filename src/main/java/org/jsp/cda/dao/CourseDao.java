package org.jsp.cda.dao;

import org.jsp.cda.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {

    Course saveCourse(Course course);

    Optional<Course> findCourseById(int id);

    List<Course> findAllCourses();

    Course updateCourse(Course course);

}
