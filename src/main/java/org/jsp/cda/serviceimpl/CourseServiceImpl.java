package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclasses.InvalidCourseIdException;
import org.jsp.cda.exceptionclasses.NoCoursesFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private DepartmentDao departmentDao;



    @Override
    public ResponseEntity<?> saveCourse(Course course) {
        Course savedCourse=courseDao.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Course saved successfully.").body(savedCourse).build());
    }

    @Override
    public ResponseEntity<?> findCourseById(int id) {
        Optional<Course> optional = courseDao.findCourseById(id);
        if(optional.isEmpty())
            throw InvalidCourseIdException.builder().message("Invalid Course Id").build();
        Course course = optional.get();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course found successfully.").body(course).build());
    }

    @Override
    public ResponseEntity<?> findAllCourses() {
        List<Course> courses = courseDao.findAllCourses();
        if(courses.isEmpty())
            throw NoCoursesFoundException.builder().message("No courses found.").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Courses found successfully.").body(courses).build());
    }

    @Override
    public ResponseEntity<?> updateCourseById(int id, Course course) {
        courseDao.findCourseById(id);

        return null;
    }

    @Override
    public ResponseEntity<?> setFacultyToCourse(int cid, int fid) {

        Optional<Faculty> optional1 = facultyDao.findFacultyById(fid);
        Optional<Course> optional2 = courseDao.findCourseById(cid);

        if(optional1.isEmpty())
            throw NoCoursesFoundException.builder().message("No faculty found.").build();

        if(optional2.isEmpty())
            throw NoCoursesFoundException.builder().message("No courses found.").build();

        Faculty faculty= optional1.get();
        Course course = optional2.get();
        course.setFaculty(faculty);

        Course saveCourse = courseDao.saveCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Faculty has set to Course successfully.").body(saveCourse).build());
    }

    @Override
    public ResponseEntity<?> setDepartmentToCourse(int cid, int did) {
        Optional<Department> optional1 = departmentDao.findDepartmentById(did);
        Optional<Course> optional2 = courseDao.findCourseById(cid);
        if(optional1.isEmpty())
            throw NoCoursesFoundException.builder().message("No department found.").build();

        if(optional2.isEmpty())
            throw NoCoursesFoundException.builder().message("No courses found.").build();

        Department department = optional1.get();
        Course course = optional2.get();
        course.setDepartment(department);

        Course saveCourse = courseDao.saveCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department has set to Course successfully.").body(saveCourse).build());
    }
}
