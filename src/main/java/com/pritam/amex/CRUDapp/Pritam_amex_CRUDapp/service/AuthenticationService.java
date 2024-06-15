package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.service;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dtos.LoginUserDto;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dtos.RegisterUserDto;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.User;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();

        user.setFullName(input.getFullName());
        user.setEmailId(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
        );

        return userRepository.findByEmailId(input.getEmail()).orElseThrow();
    }
}
