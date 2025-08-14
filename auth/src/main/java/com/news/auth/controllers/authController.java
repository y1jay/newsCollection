package com.news.auth.controllers;

import com.news.auth.services.authService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.news.auth.responses.commonResponse;
import com.news.auth.dto.userDto;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class authController {
    @Autowired
    authService authService;

    @PostMapping("/join")
    public Object JoinUser( @Valid @RequestBody userDto user,HttpServletRequest request) {
        System.out.println("test!!");
     return  authService.join(user,request);
    }
}

