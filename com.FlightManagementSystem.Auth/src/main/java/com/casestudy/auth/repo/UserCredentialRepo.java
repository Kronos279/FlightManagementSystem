package com.casestudy.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.auth.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepo  extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
}