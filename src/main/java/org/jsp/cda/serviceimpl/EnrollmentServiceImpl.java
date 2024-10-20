package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Override
    public ResponseEntity<?> saveEnrollment(int cid, int sid) {
//        Enrollment enrollment = enrollmentDao.saveEnrollment();
//        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("").body(enrollment).build());
    return null;
    }
}
