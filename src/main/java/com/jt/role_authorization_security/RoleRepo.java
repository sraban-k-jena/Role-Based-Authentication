package com.jt.role_authorization_security;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.jt.role_authorization_security.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    // This is used to extrsct the name Like [Role_User and Role_Admin] from th Role
    // class.
    Optional<Role> findByName(String name);
}
