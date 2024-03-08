package org.example.repository;

import org.example.Entity.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByAuthority(String authority);
}
