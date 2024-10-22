package org.jsp.cda.dao;

import org.jsp.cda.entity.Enrollment;

import java.util.Optional;
import java.util.List;

public interface EnrollmentDao {


    Enrollment saveEnrollment(Enrollment enrollment);

    Optional<Enrollment> findEnrollmentById(int id);

    List<Enrollment> findAllEnrollments();

    List<Enrollment> findEnrollmentsByStudentId(int sid);

    List<Enrollment> findEnrollmentByCourseId(int cid);
}
