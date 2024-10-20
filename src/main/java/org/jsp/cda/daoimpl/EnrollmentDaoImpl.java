package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentDaoImpl implements EnrollmentDao {

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
