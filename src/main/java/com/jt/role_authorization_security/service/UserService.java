package com.jt.role_authorization_security.service;

import java.util.*;
import com.jt.role_authorization_security.model.User;

public interface UserService {

    // Add Users with roles .
    User addUser(User user, Set<String> roleNames);

    // Get All Users .
    List<User> getAllUsers();

    // Get UserBy Username
    Optional<User> getUserByUsername(String username);

    // Update user
    User updateUser(int id, User updateUser, Set<String> roleNames);

    // Delete User .
    void deleteUser(int id);
}
