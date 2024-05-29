package com.Batch.in.service;

import com.Batch.in.dto.AuthenticationResponse;
import com.Batch.in.dto.RegisterRequest;

public interface RegistrationServic {
    AuthenticationResponse registration(RegisterRequest request);
}
