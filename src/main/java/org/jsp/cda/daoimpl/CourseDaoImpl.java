package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseDaoImpl implements CourseDao
{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
}
