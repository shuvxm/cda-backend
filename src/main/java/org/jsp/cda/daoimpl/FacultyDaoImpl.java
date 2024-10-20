package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyDaoImpl implements FacultyDao
{
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Optional<Faculty> findFacultyById(int id) {
        return facultyRepository.findById(id);
    }

    @Override
    public List<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }
}
