//package com.news.auth.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class securityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf((csrfConfig) ->
//                        csrfConfig.disable()
//                )
//                .authorizeHttpRequests((authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/", "/user/**").permitAll()
//                                .requestMatchers("/").permitAll()
//                ));
//
//        http
//                .formLogin(login -> login
//                        .loginPage("/") // 로그인 default 페이지
//                        .loginProcessingUrl("/user/join")
//                        .usernameParameter("name")
//                        .passwordParameter("email")
//                        .defaultSuccessUrl("/member/successLogin") // 로그인 성공시
//                        .failureForwardUrl("/member/failureLogin") // 로그인 실패시
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//
//    // 패스워드 암호화로 사용할 bean
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}