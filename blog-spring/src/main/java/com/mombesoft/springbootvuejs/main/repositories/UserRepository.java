package com.mombesoft.springbootvuejs.main.repositories;

import com.mombesoft.springbootvuejs.main.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u from User u where u.deleted_at = NULL")
    List<User> allWithoutDeleted();
    List<User> findAll();
    User findById(int id);
    User findByUsername(String username);
    //User findByEmail(String email);
}
