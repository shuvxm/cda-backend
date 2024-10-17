package org.jsp.cda.repository;

import org.jsp.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{

//    @Query(name = "select u from User u where u.username=?1 and u.password=?2")
    Optional<User> findByUsernameAndPassword(String username, String password);
}
