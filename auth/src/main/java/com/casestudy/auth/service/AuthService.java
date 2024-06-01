package com.casestudy.auth.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casestudy.auth.entity.UserCredential;
import com.casestudy.auth.repo.UserCredentialRepo;

@Service
public class AuthService {

	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private UserCredentialRepo repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        logger.info("Encoded Pass is Set in Object");
        
        repository.save(credential);
        logger.info("Credentials saved in the Database");
        return "user added to the system";
    }

    public String generateToken(String username) {
    	Optional<UserCredential> credentials = repository.findByName(username);
    	logger.info("Generating Token");
        return jwtService.generateToken(username,credentials.get().getRole());
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}