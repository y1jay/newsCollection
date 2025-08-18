package com.news.collection.services;

import com.news.collection.dto.keywordDto;
import com.news.collection.dto.keywordListDto;
import com.news.collection.dto.keywordUpdateDto;
import com.news.collection.libs.database;
import com.news.collection.libs.util;
import com.news.collection.responses.commonResponse;
import com.news.collection.responses.listResponse;
import com.news.collection.responses.singleResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class collectionService {


    @Autowired(required = false)
    singleResponse<Object> single = new singleResponse<>();

    @Autowired(required = false)
    listResponse<Object> list = new listResponse<>();


    @Autowired()
    database db;

    // 키워드 저장
    public singleResponse<Object> keywordInsert(keywordDto keyword, HttpServletRequest request) {
        String ip = util.getIp(request);
        LocalDate now = LocalDate.now();
        keyword.setReg_ip(ip);
        keyword.setReg_dt(now);
        db.save("collection", "keywordInsert", keyword);
        single.setCode(200);
        single.setMessage("키워드 등록성공");
        single.setData(keyword);
        return single;
    }

    // 키워드 리스트
    public listResponse<Object> keywordList(String keyword,String domain_type, Integer um_idx, Integer page) {
        keywordListDto params = new keywordListDto();
        params.setKeyword(keyword);
        params.setUm_idx(um_idx);
        params.setDomain_type(domain_type);
        params.setSize(10);
        params.setPage((page - 1) * params.getSize());
        List<Object> keywordList = db.list("collection", "keywordListSelect", params);
        list.setMessage("Success");
        list.setData(keywordList);
        return list;
    }

    private keywordDto keywordSelect(Integer uk_idx) {
        return (keywordDto) db.view("collection", "keywordSelect", uk_idx);
    }

    // 키워드 수정 (미노출,노출 등등)
    public singleResponse<Object> keywordUpdate(keywordUpdateDto params) {
        System.out.println("TEST");

        keywordDto keyword = keywordSelect(params.getUk_idx());
        if (params.getUse_yn() == null) {
            params.setUse_yn(keyword.getUse_yn());
        }
        if (params.getKeyword().isEmpty()) {
            params.setKeyword(keyword.getKeyword());
        }
        if(params.getDomain_type().isEmpty()){
            params.setDomain_type(keyword.getDomain_type());
        }

        db.update("collection", "keywordUpdate", params);
        single.setCode(200);
        single.setMessage("키워드 수정성공");
        single.setData(params);
        return single;
    }
    // 뉴스데이터 리스트
    // 뉴스 데이터 수정
}
