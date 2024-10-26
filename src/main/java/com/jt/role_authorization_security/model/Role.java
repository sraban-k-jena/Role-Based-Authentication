package com.jt.role_authorization_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; // Role_User , Role_Admin

    // Suppose u want to bidirectional mapping u have to use Like this Below .

    // @ManytoMany(mappedBy = "roles")
    // private Set<User> users = new HashSet<>();

}
