package com.alatoo.edu.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alatoo.edu.librarymanagementsystem.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
