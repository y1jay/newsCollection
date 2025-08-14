package com.news.collection.responses;

import lombok.Data;

@Data
public class commonResponse<T> {
    int code = 200;
    String message ="Success";
    T data ;

}
