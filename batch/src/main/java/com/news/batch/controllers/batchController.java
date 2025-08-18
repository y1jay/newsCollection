package com.news.batch.controllers;

import com.news.batch.services.batchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batch")
@RequiredArgsConstructor
public class batchController {
    private static final Logger log = LoggerFactory.getLogger(batchController.class);
    @Autowired
    batchService batchService;

    @GetMapping("/apiCall")
    public void apiCalls() {
        batchService.NaverApiCall();
    }

//    @GetMapping("/test")
//    public List<ke> test(@RequestParam(defaultValue = "") String domain_type) {
//        return batchService.keywordList(domain_type);
//
//    }

}
