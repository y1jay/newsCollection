package com.news.auth.services;

import com.news.auth.responses.commonResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.news.auth.dto.userDto;

@Service
@RequiredArgsConstructor
public class authService {

    public String join(userDto user, HttpServletRequest request) {
        return "test";
    }
}