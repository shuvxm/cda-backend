package org.jsp.cda.repository;

import org.jsp.cda.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    @Query("select e from Enrollment e where e.student.id=:sid")
    List<Enrollment> findEnrollmentsByStudentId(int sid);

    @Query("select e from Enrollment e where e.course.id=:cid")
    List<Enrollment> findEnrollmentByCourseId(int cid);
}
