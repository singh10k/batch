package com.Batch.in.serviceImp;

import com.Batch.in.config.CustomAuthenticationProvider;
import com.Batch.in.dto.AuthenticationRequest;
import com.Batch.in.dto.AuthenticationResponse;
import com.Batch.in.repository.UserRepository;
import com.Batch.in.service.LoginService;
import com.Batch.in.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LoginServiceImp implements LoginService {
    private final JwtUtils jwtUtils;
    private  final UserRepository repository;
    private final CustomAuthenticationProvider authenticationManager;
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.getFindByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);
        // Set the token attribute in the session
        return AuthenticationResponse.builder()
                .access_token(jwtToken)
                .build();
    }
}
