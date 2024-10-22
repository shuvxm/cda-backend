package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentDaoImpl implements EnrollmentDao {

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findEnrollmentsByStudentId(int sid) {
        return enrollmentRepository.findEnrollmentsByStudentId(sid);
    }

    @Override
    public List<Enrollment> findEnrollmentByCourseId(int cid) {
        return enrollmentRepository.findEnrollmentByCourseId(cid);
    }

    @Override
    public Optional<Enrollment> findEnrollmentById(int id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
