package com.news.collection.controllers;

import com.news.collection.dto.keywordListDto;
import com.news.collection.dto.keywordUpdateDto;
import com.news.collection.responses.commonResponse;
import com.news.collection.responses.listResponse;
import com.news.collection.responses.singleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.collection.services.collectionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.news.collection.dto.keywordDto;

import java.util.List;

@RestController
@RequestMapping("/collection")
@RequiredArgsConstructor
public class collectionController {
    @Autowired
    collectionService collectionService;

    @PostMapping("/keywordInsert")
    public singleResponse<Object> keywordInsert(@Valid @RequestBody keywordDto keyword, HttpServletRequest request) {
        System.out.println(keyword + "KEYWORD###############");
        return collectionService.keywordInsert(keyword, request);
    }

    @GetMapping("/keywordList")
    public listResponse<Object> keywordList(@Valid @RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "") String domain_type, @RequestParam Integer um_idx, @RequestParam Integer page) {
        return collectionService.keywordList(keyword,domain_type, um_idx, page);
    }

    @PatchMapping("/keywordUpdate")
    public singleResponse<Object> keywordUpdate(@Valid @RequestBody keywordUpdateDto params) {
        return collectionService.keywordUpdate(params);
    }
//    @GetMapping("/keyword")
//    public Object keyword(@RequestParam Integer uk_idx){
//        return collectionService.keywordSelect(uk_idx);
//    }
}