package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;

import org.jsp.cda.entity.Student;
import org.jsp.cda.exceptionclasses.InvalidEnrollmentIdFoundException;
import org.jsp.cda.exceptionclasses.NoEnrollmentFoundException;
import org.jsp.cda.exceptionclasses.NoStudentFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public ResponseEntity<?> saveEnrollment(int cid, int sid) {
        Optional<Course> optional1 = courseDao.findCourseById(cid);
        Optional<Student> optional2 = studentDao.findStudentById(sid);

        if(optional1.isEmpty())
            throw InvalidEnrollmentIdFoundException.builder().message("No Course found by this id.").build();
        if(optional2.isEmpty())
            throw InvalidEnrollmentIdFoundException.builder().message("No Student found by this id.").build();
        Course course = optional1.get();
        Student student = optional2.get();

        Enrollment enrollment = Enrollment.builder().course(course).student(student).build();
//        Enrollment enrollment = new Enrollment();
//        enrollment.setCourse(course);
//        enrollment.setStudent(student);

        enrollment = enrollmentDao.saveEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("").body(enrollment).build());
    }

    @Override
    public ResponseEntity<?> findEnrollmentByStudentId(int sid) {

        List<Enrollment> enrollments = enrollmentDao.findEnrollmentsByStudentId(sid);

        if(enrollments.isEmpty())
            throw NoStudentFoundException.builder().message("No any enrollment found by student.").build();

        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Enrollment found by this id.").body(enrollments).build());
    }

    @Override
    public ResponseEntity<?> findEnrollmentByCourseId(int cid) {
        List<Enrollment> enrollments = enrollmentDao.findEnrollmentByCourseId(cid);
        return null;
    }


    @Override
    public ResponseEntity<?> findEnrollmentById(int id) {
        Optional<Enrollment> optional = enrollmentDao.findEnrollmentById(id);
        if(optional.isEmpty())
            throw InvalidEnrollmentIdFoundException.builder().message("No enrollment found by this id.").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Enrollment found by this id.").body(optional).build());
    }

    @Override
    public ResponseEntity<?> findAllEnrollments() {
        List<Enrollment> enrollments = enrollmentDao.findAllEnrollments();
        if(enrollments.isEmpty())
            throw NoEnrollmentFoundException.builder().message("No any enrollment found in db.").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Enrollment found by this id.").body(enrollments).build());
    }
}
