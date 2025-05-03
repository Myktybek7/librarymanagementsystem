package com.alatoo.edu.librarymanagementsystem.repository;

import com.alatoo.edu.librarymanagementsystem.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByToken(String token);
    void deleteByToken(String token);
}
