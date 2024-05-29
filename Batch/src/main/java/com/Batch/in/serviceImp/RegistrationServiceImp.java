package com.Batch.in.serviceImp;

import com.Batch.in.dto.AuthenticationResponse;
import com.Batch.in.dto.RegisterRequest;
import com.Batch.in.model.User;
import com.Batch.in.repository.UserRepository;
import com.Batch.in.service.RegistrationServic;
import com.Batch.in.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImp implements RegistrationServic {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse registration(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
       userRepository.save(user);
        var token = jwtUtils.generateToken(user);

        return AuthenticationResponse.builder()
                .access_token(token)
                .build();
    }

}
