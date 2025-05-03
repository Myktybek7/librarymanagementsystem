package com.alatoo.edu.librarymanagementsystem.service.impl;

import com.alatoo.edu.librarymanagementsystem.entity.UserMail;
import com.alatoo.edu.librarymanagementsystem.repository.UserMailRepository;
import com.alatoo.edu.librarymanagementsystem.service.UserMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMailServiceImpl implements UserMailService, UserDetailsService {

    @Autowired
    private UserMailRepository userMailRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean registerUser(UserMail userMail) {
        if (userMailRepository.findByEmail(userMail.getEmail()) != null) {
            return false;
        }

        userMail.setPassword(passwordEncoder.encode(userMail.getPassword()));

        userMailRepository.save(userMail);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserMail user = userMailRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

}
