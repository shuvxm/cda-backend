package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidCourseIdException;
import org.jsp.cda.exceptionclasses.InvalidUserIdException;
import org.jsp.cda.exceptionclasses.NoFacultyFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public ResponseEntity<?> saveFaculty(Faculty faculty, int uid) {
        Optional<User> optionalUser = userDao.findUserById(uid);

        if (optionalUser.isEmpty()) {
//            throw RuntimeException("Invalid user id. Unable to save faculty");
            throw InvalidUserIdException.builder().message("Invalid user id. Unable to save faculty").build();
        }


        User user = optionalUser.get();
        faculty.setUser(user);
        Faculty saveFaculty = facultyDao.saveFaculty(faculty);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("").body(saveFaculty).build());

    }

    @Override
    public ResponseEntity<?> findFacultyById(int id) {
        Optional<Faculty> optional = facultyDao.findFacultyById(id);
        if(optional.isEmpty())
            throw InvalidCourseIdException.builder().message("Invalid Faculty Id").build();
        Faculty faculty = optional.get();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully.").body(faculty).build());
    }


    @Override
    public ResponseEntity<?> findAllFaculties() {
        List<Faculty> faculties = facultyDao.findAllFaculties();
        if(faculties.isEmpty())
            throw NoFacultyFoundException.builder().message("No such faculty found").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All faculties found successfully.").body(faculties).build());
    }

    @Override
    public ResponseEntity<?> assignDepartmentToFaculty(int fid, int did) {

        Optional<Faculty> optionalFaculty = facultyDao.findFacultyById(fid);

        if (optionalFaculty.isEmpty()) {
            throw InvalidUserIdException.builder().message("Invalid Faculty id. Unable to fnd faculty").build();
        }

        Optional<Department> optionalDepartment = departmentDao.findDepartmentById(did);

        if (optionalDepartment.isEmpty()) {
            throw InvalidUserIdException.builder().message("Invalid Department id. Unable to find department").build();
        }

        // Assign the Department to the Faculty
        Faculty faculty = optionalFaculty.get();
        Department department = optionalDepartment.get();
        faculty.setDepartment(department);


        Faculty saveFaculty = facultyDao.saveFaculty(faculty);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("").body(saveFaculty).build());
    }

    @Override
    public ResponseEntity<?> setOfficeHours(int fid, LocalTime officeHours) {

        Optional<Faculty> optional = facultyDao.findFacultyById(fid);

        if(optional.isEmpty()){
            throw InvalidUserIdException.builder().message("Invalid Faculty id. Unable to find faculty").build();
        }

        Faculty faculty = optional.get();
        faculty.setOfficeHours(officeHours);

        faculty = facultyDao.saveFaculty(faculty);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("office hours has updated to faculty").body(faculty).build());
    }


}
