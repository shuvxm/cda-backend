package org.jsp.cda.service;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface DepartmentService 
{

	ResponseEntity<?> saveDepartment(Department department);

	ResponseEntity<?> findAllDepartments();

	ResponseEntity<?> findDepartmentById(int id);

	ResponseEntity<?> deleteDepartmentsById(int id);


//	ResponseEntity<?> updateDepartmentById(int id, Department department);


}
