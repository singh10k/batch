package com.Batch.in.service;

import com.Batch.in.dto.AuthenticationRequest;
import com.Batch.in.dto.AuthenticationResponse;

public interface LoginService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
