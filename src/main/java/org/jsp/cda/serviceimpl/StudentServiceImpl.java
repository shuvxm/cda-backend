package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Student;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.*;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private UserDao userDao;

    private final static String FOLDER_PATH = "C:\\Users\\Lenovo\\Desktop\\cda_Images\\";

    @Override
    public ResponseEntity<?> saveStudent(int uid, Student student) {
        Optional<User> optional = userDao.findUserById(uid);
        // do validation here
        //
        User user = optional.get();
        student.setUser(user);
        student = studentDao.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department has set to the student").body(student).build());
    }

    @Override
    public ResponseEntity<?> findAllStudents() {
        List<Student> students = studentDao.findAllStudents();
        if(students.isEmpty())
            throw NoStudentFoundException.builder().message("No Student found.").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Students found successfully.").body(students).build());
    }

    @Override
    public ResponseEntity<?> findStudentById(int id) {
        Optional<Student> student = studentDao.findStudentById(id);
        if(student.isEmpty())
            throw NoStudentFoundException.builder().message("Invalid student id. Unable to find Student.").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Students found successfully.").body(student).build());
    }

    @Override
    public ResponseEntity<?> setDepartmentToStudent(int sid, int did) {
        Optional<Student> optional1 = studentDao.findStudentById(sid);
        Optional<Department> optional2 = departmentDao.findDepartmentById(did);

        if(optional1.isEmpty())
            throw InvalidStudentIdException.builder().message("Not found student").build();
        if(optional2.isEmpty())
            throw InvalidDepartmentIdException.builder().message("Not found department").build();

        Student student = optional1.get();
        Department department = optional2.get();
        student.setDepartment(department);
        student = studentDao.saveStudent(student);
        
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department has assigned to the student").body(student).build());
    }

    @Override
    public ResponseEntity<?> uploadPhoto(int sid, MultipartFile file) {
        Optional<Student> optional = studentDao.findStudentById(sid);
        if(optional.isEmpty())
            throw InvalidStudentIdException.builder().message(" Picture file is not uploaded successfully").build();

        Student student = optional.get();

        String photo = FOLDER_PATH + file.getOriginalFilename();

        try {
            file.transferTo(new File(photo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setPhoto(photo);
        studentDao.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Profile Photo uploaded successfully").body(student).build());
    }


}
