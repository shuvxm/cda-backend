package org.jsp.cda.service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {

    ResponseEntity<?> saveStudent(int uid, Student student);

    ResponseEntity<?> setDepartmentToStudent(int sid, int did);

    ResponseEntity<?> findAllStudents();

    ResponseEntity<?> findStudentById(int id);

    ResponseEntity<?> uploadPhoto(int sid, MultipartFile file);

}
