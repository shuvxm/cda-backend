package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.exceptionclasses.InvalidDepartmentIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentDao dao;

	@Override
	public ResponseEntity<?> saveDepartment( Department department)
	{
		Department dept=dao.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department Saved..").build()) ;
	}

	@Override
	public ResponseEntity<?> findAllDepartments() 
	{
		List<Department> allDepartments=dao.findAllDepartments();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department Saved successfully.").body(allDepartments).build()) ;
	}

	@Override
	public ResponseEntity<?> findDepartmentsById(int id) 
	{
		Optional<Department> optional=dao.findDepartmentById(id);
		if(optional.isEmpty())
			throw InvalidDepartmentIdException.builder().message("Invalid ID. Unable to find.").build();
		Department department = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department found Successfully by id..").body(department).build()) ;
	}

	@Override
	public ResponseEntity<?> deleteDepartmentsById(int id) 
	{
		Optional<Department> optional=dao.findDepartmentById(id);
		if(optional.isEmpty()){
			throw InvalidDepartmentIdException.builder().message("Invalid Department id.").build();
		}
		dao.deleteDepartment(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department deleted Successfully by id..").build()) ;
	}

	@Override
	public ResponseEntity<?> updateDepartmentById(int id, Department department)
	{
		Optional<Department> optional = dao.findDepartmentById(id);



		return null;
	}

}
