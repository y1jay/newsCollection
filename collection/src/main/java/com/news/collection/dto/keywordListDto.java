package com.news.collection.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class keywordListDto {
    Integer um_idx;
    String keyword;
    Integer page = 1;
    Integer size = 10;
}
