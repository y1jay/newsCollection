package com.news.auth.services;

import com.news.auth.responses.commonResponse;
import com.news.auth.responses.listResponse;
import com.news.auth.responses.singleResponse;
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
    singleResponse<Object> single = new singleResponse<>();

    @Autowired(required = false)
    listResponse<Object> list = new listResponse<>();

    @Autowired()
    database db;

    private userDto userSelect(String uuid) {
        return (userDto) db.view("auth", "selectUser", uuid);
    }

    public singleResponse<Object> join(userDto user, HttpServletRequest request) {
        String ip = util.getIp(request);
        LocalDate now = LocalDate.now();
        userDto uuidSelect = userSelect(user.getUuid());
        if (uuidSelect != null) {
            single.setCode(300);
            single.setMessage("이미 가입 된 회원");
            single.setData(null);
        }
        user.setJoin_dt(now);
        user.setJoin_ip(ip);
        db.save("auth", "join", user);
        single.setCode(200);
        single.setMessage("가입 완료");
        single.setData(user);
        return single;
    }
}