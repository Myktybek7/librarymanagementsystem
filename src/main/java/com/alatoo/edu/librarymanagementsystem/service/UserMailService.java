package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.UserMail;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserMailService extends UserDetailsService {
    boolean registerUser(UserMail userMail);

}

