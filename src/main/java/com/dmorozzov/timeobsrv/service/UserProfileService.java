package com.dmorozzov.timeobsrv.service;

import com.dmorozzov.timeobsrv.domain.entity.Role;
import com.dmorozzov.timeobsrv.domain.entity.UserProfile;
import com.dmorozzov.timeobsrv.domain.request.SignUpRequest;
import com.dmorozzov.timeobsrv.repository.RoleRepository;
import com.dmorozzov.timeobsrv.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileService.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Transactional
    public Boolean existsByEmail(String email) {
        return userProfileRepository.existsByEmail(email);
    }

    @Transactional
    public UserProfile createUser(SignUpRequest signUpRequest) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(signUpRequest.getEmail());
        userProfile.setUserName(signUpRequest.getUserName());
        userProfile.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        Role userRole = roleRepository.findByRoleName(Role.RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("User Role not set."));

        userProfile.setRoles(Collections.singleton(userRole));

        return userProfileRepository.save(userProfile);
    }

}
