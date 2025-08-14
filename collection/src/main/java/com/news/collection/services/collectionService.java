package com.news.collection.services;

import com.news.collection.dto.keywordDto;
import com.news.collection.libs.database;
import com.news.collection.libs.util;
import com.news.collection.responses.commonResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class collectionService {

    @Autowired(required = false)
    commonResponse<Object> res = new commonResponse<>();

    @Autowired()
    database db;

    public commonResponse<Object> keywordInsert(keywordDto keyword, HttpServletRequest request){
        String ip = util.getIp(request);
        LocalDate now = LocalDate.now();
        keyword.setReg_ip(ip);
        keyword.setReg_dt(now);
        db.save("collection","keywordInsert",keyword);
        res.setCode(200);
        res.setMessage("키워드 등록성공");
        res.setData(keyword);
        return res;
    }
}
