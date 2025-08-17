package com.news.collection.services;

import com.news.collection.dto.keywordDto;
import com.news.collection.dto.keywordListDto;
import com.news.collection.dto.keywordUpdateDto;
import com.news.collection.libs.database;
import com.news.collection.libs.util;
import com.news.collection.responses.commonResponse;
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
    commonResponse<Object> res = new commonResponse<>();

    @Autowired()
    database db;

    // 키워드 저장
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

    // 키워드 리스트
    public commonResponse<Object> keywordList(String keyword, Integer um_idx,Integer page){
        keywordListDto params = new keywordListDto();
        params.setKeyword(keyword);
        params.setUm_idx(um_idx);
        params.setSize(10);
        params.setPage((page-1)*params.getSize());
        List<Object> keywordList = db.list("collection","keywordListSelect",params);
        res.setMessage("Success");
        res.setData(keywordList);
        return res;
    }
    public keywordDto keywordSelect(Integer uk_idx){
        return (keywordDto) db.view("collection","keywordSelect",uk_idx);
    }

    // 키워드 수정 (미노출,노출 등등)
    public commonResponse<Object> keywordUpdate(keywordUpdateDto params){
        System.out.println("TEST");

        keywordDto keyword =  keywordSelect(params.getUk_idx());
        if(params.getUse_yn()==null){
            params.setUse_yn(keyword.getUse_yn());
        }
        if(params.getKeyword().isEmpty()){
            params.setKeyword(keyword.getKeyword());
        }
//        if(!keyword.getUse_yn().equals(params.getUse_yn())){
//            keyword.setUse_yn(params.getUse_yn());
//        }
//        if(!params.getKeyword().isEmpty()&&
//            !keyword.getKeyword().equals(params.getKeyword())
//        ){
//            keyword.setKeyword(params.getKeyword());
//        }
//        System.out.println(keyword.getUm_idx()+"@#!@#!@#!@@!#!");
        db.update("collection","keywordUpdate",params);
        res.setCode(200);
        res.setMessage("키워드 수정성공");
        res.setData(params);
        return res;
    }
    // 키워드 별 데이터 수집
    // 뉴스데이터 리스트
    // 뉴스 데이터 수정
}
