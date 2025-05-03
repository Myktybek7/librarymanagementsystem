package com.alatoo.edu.librarymanagementsystem.repository;

import com.alatoo.edu.librarymanagementsystem.entity.UserMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMailRepository extends JpaRepository<UserMail, Long> {
    UserMail findByEmail(String email);
}
