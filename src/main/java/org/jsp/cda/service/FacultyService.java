package org.jsp.cda.service;

import org.jsp.cda.entity.Faculty;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

public interface FacultyService {

    ResponseEntity<?> saveFaculty(Faculty faculty,int uid);

    ResponseEntity<?> findFacultyById(int fid);

    ResponseEntity<?> assignDepartmentToFaculty(int fid, int did);

    ResponseEntity<?> setOfficeHours(int fid, LocalTime officeHours);

    ResponseEntity<?> findAllFaculties();
}
