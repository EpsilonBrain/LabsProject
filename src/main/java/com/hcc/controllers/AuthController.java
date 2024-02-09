package com.hcc.controllers;

import com.hcc.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth/login")
public class AuthController {
    //methods for login and validate
    //login consumes auth request
    @Autowired
    private UserDetailServiceImpl userDetails;
}
