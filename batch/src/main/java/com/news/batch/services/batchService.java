package com.news.batch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.batch.dto.keywordDto;
import com.news.batch.dto.newsCollectionDto;
import com.news.batch.libs.apiConfig;
import com.news.batch.libs.database;
import com.news.batch.responses.listResponse;
import com.news.batch.responses.singleResponse;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.mapping.Environment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.sql.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class batchService extends apiConfig {


    private static final Logger log = LoggerFactory.getLogger(batchService.class);
    @Autowired(required = false)
    singleResponse<?> single = new singleResponse<>();

    @Autowired(required = false)
    listResponse<Object> list = new listResponse<>();


    @Autowired()
    database db;

    // 도메인 별 키워드 조회
    public List<keywordDto> keywordList(String domain_type) {
        return db.list("batch", "keywordList", domain_type);
    }

    // 뉴스 데이터 조회
    public void NaverApiCall() {
        List<keywordDto> keyword = keywordList("Naver");
        LocalDate now = LocalDate.now();

        for (int i = 1; i <= keyword.size(); i++) {

            int index = i - 1;
            log.info(index + "INDEX");
            log.info(keyword.get(1).getKeyword() + "KEYWORD");
            WebClient webClient = WebClient.builder().baseUrl(getNaverUrl()).build();
            Mono<String> response = webClient.get()
                    .uri(uriBuilder ->
                            uriBuilder
                                    .queryParam("query", keyword.get(index).getKeyword())
                                    .queryParam("display", 10)
                                    .queryParam("start", 1)
                                    .queryParam("sort", "date")
                                    .build()
                    )
                    .header("X-Naver-Client-Id", getNaverId())
                    .header("X-Naver-Client-Secret", getNaverSecret())
                    .retrieve()
                    .bodyToMono(String.class);

            // 파싱
            JSONObject jsonObject = convertStringToJSONObject(response.block());
            JSONArray jsonArr = (JSONArray) jsonObject.get("items");

            List<newsCollectionDto> dbArr = new ArrayList<newsCollectionDto>();
            for (int j = 1; j <= jsonArr.size(); j++) {
                int jindex = j - 1;
                JSONObject data = (JSONObject) jsonArr.get(jindex);
                newsCollectionDto obj = new newsCollectionDto();

                obj.setTitle(data.get("title").toString());
                obj.setLink(data.get("link").toString());
                obj.setSubject(data.get("description").toString());
                obj.setReg_dt(now);
                obj.setPub_dt(data.get("pubDate").toString().replaceAll(" ", ""));
                obj.setUm_idx(keyword.get(index).getUm_idx());
                obj.setDomain_type("Naver");
                obj.setUk_idx(keyword.get(index).getUk_idx());
                dbArr.add(obj);
            }
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dbArr", dbArr);
            log.info(map + "MAP############");
            db.save("batch", "newsCollectionInsert", map);
        }
    }


    private static JSONObject convertStringToJSONObject(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            System.err.println("JSON 파싱 오류: " + e.getMessage());
        }
        return jsonObject;
    }
//    public Flux<String> GoogleApiCall() {
//        keywordDto keyword = keywordList("Google");
//        log.info(keyword + "KEYWORD");
//        WebClient webClient = WebClient.builder().baseUrl("https://v2.api.store5000.com").build();
//        Flux<String> response = webClient.get()
//                .uri(uriBuilder ->
//                                uriBuilder
////                                .host("https://v2.api.store5000.com")
//                                        .path("/user/newsfeed/listRenew")
//                                        .queryParam("page", 1)
//                                        .queryParam("listSize", 5)
//                                        .build()
//                )
//                .retrieve()
//                .bodyToFlux(String.class);
////        Object data = response.blockFirst();
////        log.info(data + "DATA@#!@#!@#");
////        System.out.println(response + "RESPONSE@#!#@!!@#!@@!!!#################");
//        log.info(response.blockLast());
//
////        response.subscribe(System.out::println);
//        return response;
//    }
    // 회원 별 데이터 저장
    // 뉴스 이력 저장
}
