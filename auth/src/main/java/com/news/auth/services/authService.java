package com.news.auth.services;

import com.news.auth.responses.commonResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.news.auth.dto.userDto;
import com.news.auth.libs.util;
import com.news.auth.libs.database;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class authService {

    @Autowired(required = false)
    commonResponse<Object> res = new commonResponse<>();

    @Autowired()
    database db;


    public commonResponse<Object> join(userDto user, HttpServletRequest request) {
        String ip = util.getIp(request);
        LocalDate now = LocalDate.now();
//        System.out.println(now+"NOW DATE@#!@#!@#");
//            userDto insertUser =
//                    userDto.builder()
//                            .join_dt(now)
//                            .join_ip(ip)
//                            .join_type(user.getJoin_type())
//                            .name(user.getName())
//                            .email(user.getEmail())
//                            .uuid(user.getUuid())
//                            .build();
//
//            System.out.println(insertUser+"USER@@@@@@@@@@@");
//            db.save("auth","join",insertUser);
//            // TODO:  uuid 체크
        user.setJoin_dt(now);
        user.setJoin_ip(ip);
        db.save("auth", "join", user);
        res.setCode(200);
        res.setMessage("가입 완료");
        res.setData(user);
        return res;
    }
}