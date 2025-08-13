package com.news.auth.services;

import com.news.auth.responses.commonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class authService {

    public String join() {
        return "test";
    }
}