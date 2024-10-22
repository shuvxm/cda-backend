package org.jsp.cda.repository;

import org.jsp.cda.entity.Administrator;
import org.jsp.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator, Integer> {

}
