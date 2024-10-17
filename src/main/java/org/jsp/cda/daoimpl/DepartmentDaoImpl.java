package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao
{
	@Autowired
	private DepartmentRepository repository;

	@Override
	public Department saveDepartment(Department departMent) {
		return repository.save(departMent);
	}

	@Override
	public List<Department> findAllDepartments() {
		return repository.findAll();
	}

	@Override
	public Optional<Department> findDepartmentById(int id) {
		return repository.findById(id);
	}

	@Override
	public Department updateDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public void deleteDepartment(int id) {
		repository.deleteById(id);
	}


}
