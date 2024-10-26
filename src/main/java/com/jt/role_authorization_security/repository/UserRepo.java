package com.jt.role_authorization_security.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.role_authorization_security.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    // This is used to extract the username of User class that u have to entered .
    Optional<User> findByUsername(String username);
}
