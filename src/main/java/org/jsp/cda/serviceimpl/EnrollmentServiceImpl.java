package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.entity.Enrollment;

import org.jsp.cda.exceptionclasses.InvalidEnrollmentIdFoundException;
import org.jsp.cda.exceptionclasses.NoEnrollmentFoundException;
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

// complete this api
    @Override
    public ResponseEntity<?> saveEnrollment(int cid, int sid) {
//        Enrollment enrollment = enrollmentDao.findEnrollmentById();
//        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("").body(enrollment).build());
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
