package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Student;
import org.jsp.cda.exceptionclasses.NoUserFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public ResponseEntity<?> saveStudent(Student student) {
        student = studentDao.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department has set to the student").body(student).build());
    }

    @Override
    public ResponseEntity<?> setDepartmentToStudent(int sid, int did) {
        Optional<Student> optional1 = studentDao.findStudentById(sid);
        Optional<Department> optional2 = departmentDao.findDepartmentById(did);

        if(optional1.isEmpty())
            throw NoUserFoundException.builder().message("Not found student").build();
        if(optional2.isEmpty())
            throw NoUserFoundException.builder().message("Not found department").build();

        Student student = optional1.get();
        Department department = optional2.get();
        student.setDepartment(department);
        student = studentDao.saveStudent(student);
        
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department has assigned to the student").body(student).build());
    }
}
