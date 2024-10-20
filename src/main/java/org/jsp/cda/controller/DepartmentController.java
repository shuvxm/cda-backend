package org.jsp.cda.controller;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController 
{
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartment(department);
	}

	@GetMapping
	public ResponseEntity<?> findAllDepartments()
	{
		return service.findAllDepartments();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findDepartmentsById(@PathVariable int id)
	{
		return service.findDepartmentById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartmentsById(@PathVariable int id)
	{
		return service.deleteDepartmentsById(id);
	}

//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateDepartmentById(@PathVariable int id, @RequestBody Department department)
//	{
//		return service.updateDepartmentById(id, department);
//	}

}
