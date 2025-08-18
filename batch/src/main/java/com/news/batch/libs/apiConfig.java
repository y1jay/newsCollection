package com.news.batch.libs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class apiConfig {
    @Value("${naver.api.url}")
    private String naverUrl;

    @Value("${naver.api.client-id}")
    private String naverId;

    @Value("${naver.api.client-secret}")
    private String naverSecret;

    public String getNaverUrl() {
        return this.naverUrl;
    }

    public String getNaverId() {
        return this.naverId;
    }

    public String getNaverSecret() {
        return this.naverSecret;
    }
}
