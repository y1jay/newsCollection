package com.news.collection.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class keywordUpdateDto {
    Integer uk_idx;
    Boolean use_yn;
    String keyword;
    Integer um_idx;
}
