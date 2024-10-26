package com.jt.role_authorization_security.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    // @ManytoMany Defines Many to Many RelationShip between User And Role .
    // Each User can have multiple Users and Each Role can assign to multiple Users
    // .
    // fetch = FetchType.EAGER Means is used retrive data from datanbse eagerly .
    // cascade = CascadeType.ALL Means All the operation in User Entity is Affected
    // as the Role entities .
    // @JoinTable(name = "user_role") Means it Create a new New Table name is
    // user_role .
    // joinColumns = @JoinColumn(name = "user_id") it create a column name is
    // user_id which is works like a Foreign key from the User .
    // inverseJoinColumns = @JoinColumn(name = "role_id")) it create a column name
    // is role_id which is works like a Foreign key from the Role

}
