package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
