package org.jsp.cda.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController 
{
	@Autowired
	private DepartmentService service;

	@Operation(summary = "To Create the Department ", description = "This API will accept the request body of department Entity ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Department created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input data")
	} )
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartment(department);
	}

	@Operation(summary = "To find all the Department ", description = "This API will fetched all the department ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "All Departments fetched successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input data")
	} )
	@GetMapping
	public ResponseEntity<?> findAllDepartments()
	{
		return service.findAllDepartments();
	}

	@Operation(summary = "To find Department by their id ", description = "This API will fetched department by their id ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Department fetched successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input data")
	} )
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
