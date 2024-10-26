package com.jt.role_authorization_security.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jt.role_authorization_security.RoleRepo;
import com.jt.role_authorization_security.model.Role;
import com.jt.role_authorization_security.model.User;
import com.jt.role_authorization_security.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public RoleRepo roleRepo;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Override
    public User addUser(User user, Set<String> roleNames) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            roleRepo.findByName(roleName).ifPresent(roles::add);
        }
        user.setRoles(roles);

        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {

        return userRepo.findByUsername(username);

    }

    @Override
    public User updateUser(int id, User updateUser, Set<String> roleNames) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            User existingUser = user.get();

            if (updateUser.getPassword() != null && !updateUser.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
            }

            Set<Role> roles = new HashSet<>();
            for (String roleName : roleNames) {
                roleRepo.findByName(roleName).ifPresent(roles::add);
            }
            existingUser.setRoles(roles);

            return userRepo.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

}
