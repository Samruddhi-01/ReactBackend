package com.demo.fullstack_backend.service;

import com.demo.fullstack_backend.model.AuthUser;

public interface AuthService {


    AuthUser register(AuthUser user);

    boolean login(String username, String password);

}
