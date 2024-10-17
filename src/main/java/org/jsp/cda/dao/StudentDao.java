package org.jsp.cda.dao;

import org.jsp.cda.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Student saveStudent(Student student);

    Optional<Student> findStudentById(int id);

    List<Student> findAllStudents();

    void deleteStudentById(int id);

    Student updateStudent(Student student);
}
