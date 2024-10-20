package org.jsp.cda.dao;

import org.jsp.cda.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyDao{

    Faculty saveFaculty(Faculty faculty);

    Optional<Faculty> findFacultyById(int id);

    List<Faculty> findAllFaculties();
}
