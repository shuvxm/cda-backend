package org.jsp.cda.service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<?> saveStudent(Student student);

    ResponseEntity<?> setDepartmentToStudent(int sid, int did);

    ResponseEntity<?> findAllStudents();

    ResponseEntity<?> findStudentById(int id);
}
