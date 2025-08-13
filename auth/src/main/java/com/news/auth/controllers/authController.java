package com.news.auth.controllers;

import com.news.auth.services.authService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.news.auth.responses.commonResponse;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class authController {
    @Autowired
    authService authService;

    @GetMapping("/join")
    public String JoinUser() {
        System.out.println("TEST");
        return authService.join();
    }
}
//    @PostMapping("/login")
//    public SingleReponse<User> Loginuser(@RequestBody User user,HttpServletRequest request){
//        return userService.Login(user,request);
//    }
//
//    @PostMapping("/reward")
//    public CommonResponse rewarding(@RequestBody Integer idx,@RequestBody Integer type, HttpServletRequest request){
//        return userService.Reward(idx,type,request);
//    }
