package com.sandrini.leadership.repository;

import com.sandrini.leadership.domains.ERole;
import com.sandrini.leadership.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
