package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
