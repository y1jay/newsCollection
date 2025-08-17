package com.news.collection.responses;

import lombok.Data;

import java.util.List;

@Data
public class commonListResponse<T>{
    int code = 200;
    String message = "s";
    List<T> data;
}
