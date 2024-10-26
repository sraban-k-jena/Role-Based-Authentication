package com.jt.role_authorization_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.role_authorization_security.RoleRepo;
import com.jt.role_authorization_security.model.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role savedRole = roleRepo.save(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }
}
