package com.example.usercrud.repository;

import com.example.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT id, first_name, last_name, username, age, description FROM users", nativeQuery = true)
    Collection<User> getAll();

}
