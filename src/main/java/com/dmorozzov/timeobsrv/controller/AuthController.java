package com.dmorozzov.timeobsrv.controller;

import com.dmorozzov.timeobsrv.domain.entity.UserProfile;
import com.dmorozzov.timeobsrv.domain.request.BaseApiResponse;
import com.dmorozzov.timeobsrv.domain.request.LoginRequest;
import com.dmorozzov.timeobsrv.domain.request.SignUpRequest;
import com.dmorozzov.timeobsrv.security.JwtAuthenticationResponse;
import com.dmorozzov.timeobsrv.security.JwtTokenProvider;
import com.dmorozzov.timeobsrv.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserNameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userProfileService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(
                    BaseApiResponse.failure("Email Address already in use!")
            );
        }

        UserProfile userProfile = userProfileService.createUser(signUpRequest);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(userProfile.getUserName()).toUri();

//        return ResponseEntity.created(location).body(BaseApiResponse.success("User registered successfully"));
        return ResponseEntity.ok(BaseApiResponse.success("User registered successfully"));
    }
}
